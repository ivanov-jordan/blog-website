package com.blog.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.blog.website.manager.SessionManager;
import com.blog.website.manager.UserManager;
import com.blog.website.model.LoginForm;
import com.blog.website.model.RegisterForm;
import com.blog.website.model.User;
import com.blog.website.utils.PasswordUtils;
import com.blog.website.validator.RegistrationValidator;

@Controller
@RequestMapping(ProfileController.URI)
public class ProfileController {

    public static final String URI = "profile";
    public static final String URI_LOGIN = "/login";
    public static final String URI_LOGOUT = "/logout";
    public static final String URI_REGISTER = "/register";

    @Autowired
    UserManager userManager;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private RegistrationValidator registrationValidator;

    @RequestMapping(value = URI_LOGIN, method = RequestMethod.GET)
    public String loginForm(Model model) {
        LoginForm loginForm = new LoginForm();
        model.addAttribute("form", loginForm);
        return "login";
    }

    @RequestMapping(value = URI_LOGIN, method = RequestMethod.POST)
    public ModelAndView loginSubmit(@ModelAttribute("form") LoginForm loginForm, BindingResult result,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");

        if (loginForm != null) {
            User user = userManager.getUser(loginForm.getUsername());
            if (user == null) {
                result.reject("invalid.user", "invalid user");
                return mav;
            } else {
                if (!PasswordUtils.checkPassword(loginForm.getPassword(), user.getPassword())) {
                    result.reject("invalid.user.pass", "wrong user / pass");
                    return mav;
                }
            }

            sessionManager.init(user, request);
            mav.setView(new RedirectView(HomeController.URI, true, true, false));
        }

        return mav;
    }

    @RequestMapping(value = URI_LOGOUT, method = RequestMethod.GET)
    public View logout(HttpServletRequest request) {
        sessionManager.destroy(request);
        return new RedirectView(HomeController.URI, true, true, false);
    }

    @RequestMapping(value = URI_REGISTER, method = RequestMethod.GET)
    public String registerForm(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("form", registerForm);
        return "register";
    }

    @RequestMapping(value = URI_REGISTER, method = RequestMethod.POST)
    public ModelAndView registerSubmit(@ModelAttribute("form") RegisterForm registerForm, BindingResult result,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("register");
        registrationValidator.validateForm(registerForm, result);

        if (!result.hasErrors()) {
            User user = userManager.createUser(registerForm.toEntity());
            sessionManager.init(user, request);
            mav.setView(new RedirectView(HomeController.URI, true, true, false));
        }
        return mav;
    }

}
