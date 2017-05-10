package com.miku.web.tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie管理工具
 * Created by henrybit on 2016/11/30.
 * @version 1.0
 */
public class CookiesTools {

    /**
     * 新增一个Cookie
     * @param response
     * @param key
     * @param value
     */
    public static void addCookie(HttpServletResponse response, String key, String value) {
        if (response == null) return;
        addCookie(response, key, value, 3600*24);
    }

    /**
     * 新增一个Cookie
     * @param response
     * @param key
     * @param value
     * @param expireTime
     */
    public static void addCookie(HttpServletResponse response, String key, String value, int expireTime) {
        if (response == null) return;
        addCookie(response, key, value, expireTime, "/");
    }

    /**
     * 新增一个Cookie
     * @param response
     * @param key
     * @param value
     * @param expireTime
     * @param path
     */
    public static void addCookie(HttpServletResponse response, String key, String value, int expireTime, String path) {
        if (response == null) return;
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(expireTime);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    /**
     * 删除一个Cookie
     * @param response
     * @param key
     */
    public static void deleteCookie(HttpServletResponse response, String key) {
        if (key == null || key.equals("")) return ;
        if (response == null) return;
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * 获取指定的Cookie信息
     * @param request
     * @param key
     * @return Cookie
     */
    public static Cookie getCookie(HttpServletRequest request, String key) {
        if (key == null || key.equals("")) return null;
        if (request == null) return null;
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        if (cookies == null) return null;
        for(Cookie cookie : cookies){
            if (cookie == null) continue;
            String name = cookie.getName();// get the cookie name
            String value = cookie.getValue(); // get the cookie value
            if (key.equals(name))
                return cookie;
        }
        return null;
    }

}
