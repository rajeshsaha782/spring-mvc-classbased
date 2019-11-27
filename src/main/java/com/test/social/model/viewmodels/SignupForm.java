package com.test.social.model.viewmodels;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupForm {

//    @Size(min=1,message = "Name is required!")
    @NotEmpty(message = "Name is required!!")
    private String name;

    @NotEmpty(message = "Email is required!")
    @Pattern(regexp = "^[a-zA-Z0-9]+([._-][a-zA-Z0-9]+)*@[a-zA-Z0-9]{2,50}([.][a-z]{2,5})+$",
            message = "Invalid Email Format")
    private String email;


    @Size(min = 6, max = 20, message = "password must contains 6-20 characters")
    private String password;

    @Size(min = 6, max = 20, message = "password must contains 6-20 characters")
    private String re_password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }
}
