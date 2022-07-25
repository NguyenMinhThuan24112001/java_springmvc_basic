package com.learnSpringMVC.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin/home");// tham số ở đây là định nghĩa trang cần trả về, home ở đây là file/views/home.jsp
        return mav;
    }
    @RequestMapping(value = "/quan-tri/trang-chu2",method = RequestMethod.GET)
    public String homePage1(Model model){
        model.addAttribute("model",model);
        return  "admin/home";
    }

//    @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//    public ModelAndView springMVCPage() {
//        ModelAndView mav = new ModelAndView("springmvc");
//        return mav;
//    }
}
