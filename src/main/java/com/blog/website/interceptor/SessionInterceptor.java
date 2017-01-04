package com.blog.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blog.website.controller.HomeController;
import com.blog.website.controller.ProfileController;
import com.blog.website.manager.SessionManager;
import com.blog.website.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

    public static final String SESSION_OBJECT = "user";

    @Autowired
    private SessionManager sessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("Intercepted! " + request.getRequestURI());
        if (requireSession(request.getRequestURI())) {
            log.info("This URI requires ession");
            User user = sessionManager.get(request);
            if (user == null) {
                log.info("Will redirect to home page as there is no session");
                response.sendRedirect(request.getContextPath() + HomeController.URI);
                return false;
            }
        }

        return true;
    }

    private boolean requireSession(String uri) {
        return (uri != null
                && (uri.contains(ProfileController.URI_LOGOUT)));
    }

}
