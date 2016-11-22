package com.jd.matchagenttest.utils;

import org.junit.Test;

/**
 * Created by weijiang
 * Date: 2016/11/22
 * Desc:
 */


public class MD5UtilsTest {

    @Test
    public void testGetMDHashStr() {
        String ss = "uoujouououousdfsdf";
        String rs = MD5Utils.getMDHashStr(ss);
        System.out.println(rs);
    }
}
