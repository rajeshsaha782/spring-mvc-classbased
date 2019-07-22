package com.test.social.controller.web;

import com.test.social.UserSessionManager;
import com.test.social.model.entities.User;
import com.test.social.model.viewmodels.LoginForm;
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
public class LoginController {

    @RequestMapping("")
    public String index(HttpServletRequest request){
        User loggedUser = UserSessionManager.getSessionUser(request);
        if(loggedUser!=null){
            return "redirect:/home";
        }
        return "redirect:/login";
    }


    @RequestMapping("/login")
    public String index(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result, Model model,
                            HttpServletRequest request){
        if(result.hasErrors())
        {
            return "login/index";
        }
        else {
            User user = new User();
            user.setEmail(loginForm.getEmail());
            UserSessionManager.setSessionUser(request,user);
            return "redirect:/home";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        UserSessionManager.RemoveSessionuser(request);
        return "redirect:/login";
    }
}
