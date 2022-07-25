package com.learnSpringMVC.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    @RequestMapping(value = "/trang-chu/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("web/home");// tham số ở đây là định nghĩa trang cần trả về, home ở đây là file/views/home.jsp
        return mav;
    }

//    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
//    public ModelAndView loginPage() {
//        ModelAndView mav = new ModelAndView("login");
//        return mav;
//    }

//    @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//    public ModelAndView springMVCPage() {
//        ModelAndView mav = new ModelAndView("springmvc");
//        return mav;
//    }
}
