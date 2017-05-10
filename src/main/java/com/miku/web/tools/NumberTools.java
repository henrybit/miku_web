package com.miku.web.tools;

import java.util.Random;

/**
 * 数字工具<br>
 * Created by henrybit on 2016/11/28.
 * @version 1.0
 */
public class NumberTools {

    /**
     * 字符串转Long<br>
     * @param str
     * @return long
     */
    public static long stringToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
        }
        return -1L;
    }

    /**
     * 字符串转Int<br>
     * @param str
     * @return int
     */
    public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * 字符串转Double<br>
     * @param str
     * @return double
     */
    public static double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
        }
        return -1D;
    }

    /**
     * 字符串转Float<br>
     * @param str
     * @return float
     */
    public static float stringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
        }
        return -1F;
    }

    /**
     * 字符数组转Long
     * @param str
     * @return
     */
    public static long[] stringToLong(String[] str) {
        try {
            long[] values = new long[str.length];
            for (int i=0; i<str.length; i++) {
                values[i] = stringToLong(str[i]);
            }
            return values;
        } catch (Exception e) {
        }
        return null;
    }

    public static int randomIn(int start, int end) {
        Random random = new Random();
        int r = random.nextInt(end-start);
        return r+start;
    }

    public static int randomIn(int limit) {
        Random random = new Random();
        int m = random.nextInt(limit);
        return m;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            //int r1 = randomIn(4, 8);
            int r2 = randomIn(60);
            //System.out.println("r1="+r1);
            System.out.println("r2="+r2);
        }
    }
}
