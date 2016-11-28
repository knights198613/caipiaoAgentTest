package com.jd.matchagenttest.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by weijiang
 * Date: 2016/11/22
 * Desc: MD5加密工具
 */
public class MD5Utils {

    public static final char[] HEX_ARRAY = "0123456789abcedf".toCharArray();

    /**
     * 返回Md5摘要的信息串
     * @param source
     * @return
     */
    public static String getMDHashStr(String source) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = md.digest(source.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return bytes2HexStr(result);
    }

    /**
     * 将md5摘要过得字节数组转换为16进制的字符串
     * @param b
     * @return
     */
    public static String bytes2HexStr(byte[] b) {
        String rs = null;
        char[] ss = new char[b.length * 2];
        for(int i=0; i<b.length; i++) {
            byte tmp = b[i];
            ss[i] = HEX_ARRAY[tmp >> 4 & 0xf];
            ss[i] = HEX_ARRAY[tmp & 0xf];
        }
        return rs = new String(ss);
    }
}
