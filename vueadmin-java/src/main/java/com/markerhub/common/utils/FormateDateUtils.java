package com.markerhub.common.utils;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 * 日期格式化yyyy-MM-dd
 *
 * @param date
 * @return
 */	
@Slf4j
public class FormateDateUtils{
    public static Date paseStringDate(String date, String format) {
        try {
            return  new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("出现错误{}",e);

        }
        
        return null;
    }
    // 
    public static String formateDate(Date date,String format){
            return  new SimpleDateFormat(format).format(date);
      
    }
    // 比较时间相差天数
    public static long jdk8DayDiff(String date1, String date2,String format) {
        if (null == date1 || null == date2) {
            return -1;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
    
        LocalDate d1 = LocalDate.parse(date1,dtf);
    
        LocalDate d2 = LocalDate.parse(date2,dtf);
    
        long diff = ChronoUnit.DAYS.between(d1, d2);
    
        return diff;
    }
    
    



}




