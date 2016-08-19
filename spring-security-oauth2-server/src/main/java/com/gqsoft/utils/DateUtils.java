package com.gqsoft.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/** 
* @ClassName: DateUtils 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GQ Email:guoquan913@qq.com
* @date 2016年8月19日 下午3:29:46 
*  
*/
public abstract class DateUtils {

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * Private constructor
     */
    private DateUtils() {
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }


    public static String toDateTime(LocalDateTime date) {
        return toDateTime(date, DEFAULT_DATE_TIME_FORMAT);
    }

    public static String toDateTime(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
    }



    public static String toDateText(LocalDate date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
    }


}