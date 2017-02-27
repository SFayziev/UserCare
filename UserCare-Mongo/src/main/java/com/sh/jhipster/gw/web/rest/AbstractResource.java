package com.sh.jhipster.gw.web.rest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Faiziev Shuhrat on 11/25/16.
 */

abstract class AbstractResource {
     Integer getProjectId(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest();

        return  Integer.valueOf(request.getHeader("projid"));
    }
}
