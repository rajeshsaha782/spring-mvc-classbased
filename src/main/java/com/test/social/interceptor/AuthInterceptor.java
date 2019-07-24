package com.test.social.interceptor;

import com.test.social.UserSessionManager;
import com.test.social.model.entities.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

public class AuthInterceptor implements HandlerInterceptor {

    String[] excludeMappingUrls = new String[]{
//            "",
//            "/",
//            "/login",
//            "/signup"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle!!");

        String path = new URL(request.getRequestURL().toString()).getPath();
        System.out.print("path----> "+path);
//        for(String url:excludeMappingUrls){
//            if(url.contains(path)){
////                System.out.println("excludeMapping--->"+path);
//                return true;
//            }
//        }
        User user = UserSessionManager.getSessionUser(request);
        if(user==null){
            System.out.println(" ---> Block");
            response.sendRedirect("/");
            return false;
        }
        System.out.println(" ---> Pass");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println("Post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
//        System.out.println("Inside after completion");
    }

}
