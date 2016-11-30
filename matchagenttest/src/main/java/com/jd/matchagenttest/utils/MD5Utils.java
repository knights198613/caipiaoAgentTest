package com.jd.matchagenttest.utils;

import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by weijiang
 * Date: 2016/11/22
 * Desc: MD5加密工具
 */
public class MD5Utils {

    public static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    public static final String CHAR_ENCODING = "UTF-8";

    /**
     * 返回Md5摘要的信息串
     * @param source
     * @return
     */
    public static String getMDHashStr(String source) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int x = md.getDigestLength();
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
        StringBuilder sb = new StringBuilder(b.length *2);
        for(int i=0; i<b.length; i++) {
            byte tmp = b[i];
             sb.append(HEX_ARRAY[(tmp >> 4) & 0xf]).append(HEX_ARRAY[tmp & 0xf]);
             //sb.append(HEX_ARRAY[tmp & 0xf]);

        }
        return rs = sb.toString();
    }

    /**
     * 利用google guava 的hash摘要算法对字符串源进行摘要
     * @param source
     * @return
     */
    public static String getMd5Str(String source) {
        String result = null;
        //result = Hashing.md5().newHasher().putString(source, Charset.forName(CHAR_ENCODING)).hash().toString();
        try {
            result = Hashing.md5().hashBytes(source.getBytes("UTF-8")).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
