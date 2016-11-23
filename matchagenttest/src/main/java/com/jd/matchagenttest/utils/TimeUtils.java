package com.jd.matchagenttest.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by weijiang
 * Date: 2016/11/23
 * Desc: 时间工具类
 */
public class TimeUtils {

    static Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 获取系统的当前日期的时间戳，精确到毫秒
     * @return
     */
    public static String getCurrentTimeStamp() {
        Date date = calendar.getTime();
        return sp.format(date);
    }

    /**
     * 获取当前系统的毫秒值
     * @return
     */
    public static String getSystemCurrentTimeStamp() {
        long currentTimeMills = System.currentTimeMillis();
        return String.valueOf(currentTimeMills);
    }
}
