package com.teng.Utils;

import com.teng.entity.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

        public static String getCurrent(){
                return getCurrentTime("yyyy-MM-dd HH:mm:ss.SSS");
        }

        public static String getCurrentTime(String format){
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                return dateTime.format(formatter);
        }

        public static long getAddMinuteByCurrent(Date start){
                long adder = new Date().getTime() - start.getTime();
                return adder/(30 * 60 * 1000);
        }

        public static long getAddMinute(Date current, Date start){
                long adder = current.getTime() - start.getTime();
                return adder/(30 * 60 * 1000);
        }

        public static String getWelcomeLastLoginTime(String last){
                try {
                        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                        //LocalDateTime dateTime = LocalDateTime.parse("yyyy-MM-dd HH:mm:ss.SSS");
                        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(last);
                        long adder = new Date().getTime() - date.getTime();
                        long count = adder/(60 * 1000);
                        if (count < 3){
                                return "刚刚";
                        } else {
                                if (count < 60){
                                        return "三分钟前";
                                } else {
                                        if(count < 60 * 24){
                                                return "一小时前";
                                        } else {
                                             if(count < 60 * 24 * 7){
                                                     return "1天前";
                                             } else {
                                                     if(count < 60 * 24 * 30){
                                                             return "一个月前";
                                                     } else {
                                                             if(count < 60 * 24 * 365){
                                                                     return "一年前";
                                                             }
                                                             return last;
                                                     }
                                             }
                                        }
                                }
                        }
                } catch (ParseException e) {
                        return "刚刚";
                }
        }

}
