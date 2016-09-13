package com.sh.utils.exception;

/**
 * Created by Lenovo on 16.02.2016.
 */
public interface StatusAware {
    int getCode();
    String getMessage();
    String getDefaultValue();
}
