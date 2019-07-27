package com.test.social.controller.web;

import com.test.social.UserSessionManager;
import com.test.social.model.entities.User;
import com.test.social.model.viewmodels.LoginForm;
import com.test.social.model.viewmodels.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class SignupController {
    @RequestMapping("/signup")
    public String index(Model model){
        model.addAttribute("signupForm", new SignupForm());
        return "signup/index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result, Model model,
                            HttpServletRequest request){
        if(result.hasErrors())
        {
            return "signup/index";
        }
        else if(!signupForm.getPassword().equals(signupForm.getRe_password())){
            model.addAttribute("errMessage","Password and Re-type password must be same.");
            return "signup/index";
        }
        else {
            return "redirect:/login";
        }
    }
}
