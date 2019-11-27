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
    public String index(HttpServletRequest request) {
        User loggedUser = UserSessionManager.getSessionUser(request);
        if (loggedUser != null) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }


    @RequestMapping("/login")
    public String index(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result, Model model,
                            HttpServletRequest request) {
        if (result.hasErrors()) {
            return "login/index";
        } else {
            try {
                User checkedUser = new User();
                // demo
                checkedUser.setEmail("abc@gmail.com");
                checkedUser.setPassword("123456");

                if (checkedUser == null) {
                    model.addAttribute("errMessage", "Invalid User.");
                    return "login/index";
                } else if (!isValidUser(checkedUser, loginForm)) {
                    model.addAttribute("errMessage", "Invalid credentials.");
                    return "login/index";
                }

                User user = new User();
                user.setEmail(loginForm.getEmail());
                UserSessionManager.setSessionUser(request, user);
                return "redirect:/home";
            } catch (Exception ex) {
                ex.printStackTrace();
                model.addAttribute("errMessage", "Server Error!!!");
                return "login/index";
            }
        }
    }

    private boolean isValidUser(User user, LoginForm loginForm) {
        if (user.getEmail().equals(loginForm.getEmail()) && user.getPassword().equals(loginForm.getPassword())) {
            return true;
        }
        return false;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        UserSessionManager.RemoveSessionuser(request);
        return "redirect:/login";
    }
}
