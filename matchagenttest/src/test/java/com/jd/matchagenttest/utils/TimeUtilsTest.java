package com.jd.matchagenttest.utils;

import org.junit.Test;

/**
 * Created by weijiang
 * Date: 2016/11/23
 * Desc:
 */
public class TimeUtilsTest {

    @Test
    public void TestGetTimeStamp() {
        String ss = TimeUtils.getCurrentTimeStamp();
        String dd = TimeUtils.getSystemCurrentTimeStamp();
        System.out.println(ss);
        System.out.println(dd);

    }
}
