package com.sh.utils;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

/**
 * Created by Admin on 03.09.2015.
 */
public class TimeAgo implements Serializable {
    private  String i18nvalue;
    private long agovalue=0;


    public TimeAgo(Date date) {
        DateTime dt = new DateTime(date);
        LocalDateTime t1 = LocalDateTime.of( dt.getYear() , dt.getMonthOfYear(), dt.getDayOfMonth(),dt.getHourOfDay(), dt.getMinuteOfHour());
        LocalDateTime t2 = LocalDateTime.now();
        Period period = Period.between(t1.toLocalDate(), t2.toLocalDate());
        Duration duration = Duration.between(t1, t2);
        if (period.getYears()>0){
            if(period.getYears()==1) {i18nvalue="timeAgo.year";} else {i18nvalue="timeAgo.years";} agovalue= period.getYears();
            return;
        }
        if (period.getMonths()>0){
            if(period.getMonths()==1){i18nvalue ="timeAgo.month";} else {i18nvalue ="timeAgo.month";} agovalue= period.getMonths(); return;  }
        if (period.getDays()>0){
            if(period.getDays()==1){i18nvalue="timeAgo.day";}else {i18nvalue="timeAgo.days";} agovalue= period.getDays(); return;  }
        if (duration.toHours()>0){
            if(duration.toHours()==1){i18nvalue="timeAgo.hour";} else {i18nvalue="timeAgo.hours";} agovalue= duration.toHours() ; return;  }
        if (duration.toMinutes()>0){
            if(duration.toMinutes()==1){i18nvalue="timeAgo.minute";}else {i18nvalue="timeAgo.minutes";} agovalue= duration.toMinutes(); return;  }
        i18nvalue="timeAgo.now";
        agovalue=0;
    }

    public String getI18nvalue() {
        return i18nvalue;
    }

    public void setI18nvalue(String i18nvalue) {
        this.i18nvalue = i18nvalue;
    }

    public long getAgovalue() {
        return agovalue;
    }

    public void setAgovalue(Integer agovalue) {
        this.agovalue = agovalue;
    }
}
