package com.miku.web.tools;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by henrybit on 2017/4/20.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        String wechatId = "ocP3zs-R0t7zsUYaCyKcm9ej2-Bw";
        String echatId = URLEncoder.encode(wechatId,"utf8");
        System.out.println(echatId);
        String name = "哇啊";
        System.out.println(URLEncoder.encode(name, "utf8"));
    }
}
