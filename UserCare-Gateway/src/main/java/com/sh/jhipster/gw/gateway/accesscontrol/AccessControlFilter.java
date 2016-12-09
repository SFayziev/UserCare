package com.sh.jhipster.gw.gateway.accesscontrol;

import com.sh.jhipster.gw.config.JHipsterProperties;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Zuul filter for restricting access to backend micro-services endpoints.
 */
public class AccessControlFilter extends ZuulFilter {

    private final Logger log = LoggerFactory.getLogger(AccessControlFilter.class);


    @Inject
    private RouteLocator routeLocator;

    @Inject
    private JHipsterProperties jHipsterProperties;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * Filter requests on endpoints that are not in the list of authorized microservices endpoints.
     */
    @Override
    public boolean shouldFilter() {
        String requestUri = RequestContext.getCurrentContext().getRequest().getRequestURI();
        RequestContext ctx = RequestContext.getCurrentContext();


        ctx.addZuulRequestHeader("projid", "2");
        try {
            getProject(RequestContext.getCurrentContext().getRequest());
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
//            e.printStackTrace();
        }


        // If the request Uri does not start with the path of the authorized endpoints, we block the request
        for (Route route : routeLocator.getRoutes()) {
            String serviceUrl = route.getFullPath();
            String serviceName = route.getId();

            // If this route correspond to the current request URI
            // We do a substring to remove the "**" at the end of the route URL
            if (requestUri.startsWith(serviceUrl.substring(0, serviceUrl.length() - 2))) {
				return !isAuthorizedRequest(serviceUrl, serviceName, requestUri);
            }
        }
        return true;
    }

    private boolean isAuthorizedRequest(String serviceUrl, String serviceName, String requestUri) {
        Map<String, List<String>> authorizedMicroservicesEndpoints = jHipsterProperties.getGateway()
            .getAuthorizedMicroservicesEndpoints();

        // If the authorized endpoints list was left empty for this route, all access are allowed
        if (authorizedMicroservicesEndpoints.get(serviceName) == null) {
            log.debug("Access Control: allowing access for {}, as no access control policy has been set up for " +
                "service: {}", requestUri, serviceName);
            return true;
        } else {
            List<String> authorizedEndpoints = authorizedMicroservicesEndpoints.get(serviceName);

            // Go over the authorized endpoints to control that the request URI matches it
            for (String endpoint : authorizedEndpoints) {
                // We do a substring to remove the "**/" at the end of the route URL
                String gatewayEndpoint = serviceUrl.substring(0, serviceUrl.length() - 3) + endpoint;
                if (requestUri.startsWith(gatewayEndpoint)) {
                    log.debug("Access Control: allowing access for {}, as it matches the following authorized " +
                        "microservice endpoint: {}", requestUri, gatewayEndpoint);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();


        ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        if (ctx.getResponseBody() == null && !ctx.getResponseGZipped()) {
            ctx.setSendZuulResponse(false);
        }
        log.debug("Access Control: filtered unauthorized access on endpoint {}", ctx.getRequest().getRequestURI());
        return null;
    }


    public void  getProject( HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession();
        String urlpath = new URL(request.getRequestURL().toString()).getHost();

        String url=null;
        try {
            url = urlpath.substring(0,urlpath.indexOf(".") );
        } catch (Exception e) {

            log.error( String.format("Can't get project name from %s : %s " , urlpath, e.getMessage()));
//            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return null;
        }

        if (url.length()>0){
            if (session.getAttribute("project_alis")!= null && session.getAttribute("project_alis").equals(url)){
//                return getProjectbyId(Integer.parseInt(session.getAttribute("project_id").toString())) ;
            }
            else{
//                ProjectDTO projectDTO=getProjectbyAlies(url);
//                if (projectDTO!= null){
                    session.setAttribute("project_id",2);
                    session.setAttribute("project_alias","ttl");
                    session.setAttribute("project_name","ttl");
//                }
//                else{
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
//                }

//                return  projectDTO;
            }
        }
//        response.sendError(HttpServletResponse.SC_NOT_FOUND);
//        return null;
    }
}
