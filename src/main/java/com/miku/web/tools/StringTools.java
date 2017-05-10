package com.miku.web.tools;

/**
 * Created by henrybit on 2017/3/15.
 * @version 1.0
 */
public class StringTools {

    /**
     * 是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        return false;
    }

    /**
     * 是否为非空
     * @param str
     * @return boolean-false:空;true:非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
