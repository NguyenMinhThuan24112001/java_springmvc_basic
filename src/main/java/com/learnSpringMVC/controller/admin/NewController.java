package com.learnSpringMVC.controller.admin;

import com.learnSpringMVC.model.NewModel;
import com.learnSpringMVC.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller(value = "newControllerOfAdmin")
public class NewController {

    @Autowired
    private INewService iNewService;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@ModelAttribute("model")NewModel model) {
        ModelAndView mav = new ModelAndView("admin/new/list");// tham số ở đây là định nghĩa trang cần trả về, home ở đây là file/views/home.jsp
        model.setListResult(iNewService.findAll());
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute("model")NewModel model) {
        ModelAndView mav = new ModelAndView("admin/new/edit");// tham số ở đây là định nghĩa trang cần trả về, home ở đây là file/views/home.jsp
        mav.addObject("model", iNewService.update(model));
//        model.set
        return mav;
    }



//    @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
//    public ModelAndView springMVCPage() {
//        ModelAndView mav = new ModelAndView("springmvc");
//        return mav;
//    }
}
