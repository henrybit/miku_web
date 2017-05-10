package com.miku.web.controller;

import com.miku.web.entity.response.BaseResponse;
import com.miku.web.tools.JSONTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * 基础Controller层
 * Created by henrybit on 2017/3/16.
 * @version 1.0
 */
@Controller
@RequestMapping(value="/")
public class BaseController {

    @RequestMapping(value="login.do")
    protected ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    protected void outWrite(HttpServletResponse response, BaseResponse info) {
        try {
            OutputStream os = response.getOutputStream();
            os.write(JSONTools.toJson(info).getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
