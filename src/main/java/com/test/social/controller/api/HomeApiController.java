package com.test.social.controller.api;

import com.test.social.dao.UserDao;
import com.test.social.model.viewmodels.LoginForm;
import com.test.social.model.viewmodels.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeApiController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/get")
    public ApiStatus get(@RequestParam(value = "id",required = false) Integer id){
        if(id == null)
        {
//            return new ApiStatus(HttpStatus.OK,"Get Method.");
            return new ApiStatus(HttpStatus.OK,"Get Method.",userDao.getAllUser());
        }
        else return new ApiStatus(HttpStatus.OK,"Get Method with RequestParam.",id);
    }

    @RequestMapping(value = "/get/{id}")
    public ApiStatus getWithPathVariable(@PathVariable Integer id){
        return new ApiStatus(HttpStatus.OK,"Get Method with path variable",id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Object post(HttpServletRequest request,@RequestHeader("Content-Type") String contentType, @RequestBody(required = false) Map body){
        Map data = new HashMap();
        if(contentType.equals("application/json")){
            data = body;
        } else return new ResponseEntity<ApiStatus>(HttpStatus.BAD_REQUEST);

        return new ApiStatus(HttpStatus.OK,"Post Method.",data);
    }


    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Object post(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result){
        Map data = new HashMap();
        if(result.hasErrors())
        {
            Map errMsg = new HashMap();
            for(ObjectError error:result.getAllErrors()){
                FieldError fe = (FieldError) error;
                errMsg.put(fe.getField(), fe.getDefaultMessage());
            }
            return new ApiStatus(HttpStatus.BAD_REQUEST,"Error!",errMsg);
        }
        return new ApiStatus(HttpStatus.OK,"Post Method.",data);
    }

//    @RequestMapping(value = "/post", method = RequestMethod.POST)
//    public Object post1(HttpServletRequest request,@RequestHeader("Content-Type") String contentType){
//        Map data = new HashMap();
//        if(contentType.equals("application/x-www-form-urlencoded")){
//            data = request.getParameterMap();
//        } else return new ResponseEntity<ApiStatus>(HttpStatus.BAD_REQUEST);
//
//        return new ApiStatus(HttpStatus.OK,"Post Method.",data);
//    }
}
