package com.sh.usercare.db.service;

import com.sh.utils.exception.N18IErrorCodes;
import com.sh.utils.exception.N18iException;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by Admin on 16.08.2016.
 */
public class GenericService  {
    public EntityManager getEntityManager() {
        return entityManager;
    }


    protected Collection<? extends GrantedAuthority> getCurrentUserAuthority(){
        return  SecurityContextHolder.getContext().getAuthentication().getAuthorities() ;
    }

    public boolean isInGrantedAuthority (String... authority) throws N18iException {
        for (GrantedAuthority g :getCurrentUserAuthority()){
            if (ArrayUtils.indexOf(authority, g )>=0) return true;
        }
        throw   new N18iException(N18IErrorCodes.FORBIDDEN);
    }

// Private fields

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

}
