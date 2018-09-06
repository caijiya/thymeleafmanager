package com.zy.thymeleafmanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginController {
    private Logger logger = LoggerFactory.getLogger(loginController.class);

    @RequestMapping(value = "/")
    public ModelAndView hello(HttpServletResponse response) {
        logger.info("登陆。");
        //   ModelAndView modelAndView = new ModelAndView("login/common/common_header");
        ModelAndView modelAndView = new ModelAndView("login/register");
        modelAndView.addObject("name", "赵阳");
        Cookie cookie = new Cookie("name", "ZhaoYang");
        cookie.setMaxAge(10000);
        response.addCookie(cookie);
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(HttpServletRequest request) {
//        String user = request.getParameter("user");
//        String pwd = request.getParameter("pwd");
//        System.out.println(user);
//        return user;
//
//    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody JSONObject jsonObject) {
//        if (!StringUtils.isEmpty(jsonObject.get("name"))) {
//            return jsonObject;
//        }
//        return jsonObject;
        return JSON.toJSONString(jsonObject);
    }

}
