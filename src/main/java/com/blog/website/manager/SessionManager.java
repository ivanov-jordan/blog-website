package com.blog.website.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.blog.website.model.User;

@Component
public class SessionManager {

    public static final String SESSION_OBJECT_NAME = "profile";

    public void init(User user, HttpServletRequest request) {
        destroy(request);

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(1800); // TODO set in config
        session.setAttribute(SESSION_OBJECT_NAME, user);
    }

    public User get(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        Object userObj = session.getAttribute(SESSION_OBJECT_NAME);
        return (userObj != null) ? ((User) userObj) : null;
    }

    public void destroy(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        } else {
            session.removeAttribute(SESSION_OBJECT_NAME);
            session.invalidate();
        }
    }

}
