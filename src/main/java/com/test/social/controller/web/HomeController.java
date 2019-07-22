package com.test.social.controller.web;


import com.test.social.UserSessionManager;
import com.test.social.model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

//    @RequestMapping("")
//    public String index(Model model){
//        model.addAttribute("name","Rajesh");
//        return "home/index";
//    }

    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("home/index");
        User user = UserSessionManager.getSessionUser(request);
        modelAndView.addObject("email",user.getEmail());
        return modelAndView;
    }
}
