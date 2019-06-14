package com.test.social.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("name","Rajesh");
        return "home-index";
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("home-index");
        modelAndView.addObject("name","WSIT");
        return modelAndView;
    }
}
