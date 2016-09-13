package com.sh.utils.exception;

/**
 * Created by Lenovo on 16.02.2016.
 */
public interface N18nLoggable extends StatusAware {
    LoggingLevel getLevel();
    String getN18nCode();
}
