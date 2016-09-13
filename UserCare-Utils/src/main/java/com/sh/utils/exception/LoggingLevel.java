package com.sh.utils.exception;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Lenovo on 16.02.2016.
 */
@XmlType(
        name = "logging-level"
)
@XmlEnum
public enum LoggingLevel {
    DEVELOPMENT,
    QA,
    SUPPORT,
    OPERATIONS;

    private LoggingLevel() {
    }

    public String value() {
        return this.name();
    }

    public static LoggingLevel fromValue(String v) {
        return valueOf(v);
    }
}
