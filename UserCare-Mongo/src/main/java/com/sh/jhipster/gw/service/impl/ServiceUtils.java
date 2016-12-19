package com.sh.jhipster.gw.service.impl;

/**
 * Created by Faiziev Shuhrat on 12/16/16.
 */
public class ServiceUtils {

    public static boolean isNotNullorZero(final Long number){
        return number != null && (number != 0);
    }
}
