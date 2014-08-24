package org.boom.web.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.boom.web.BoomServiceLocators;
import org.boom.web.domain.User;
import org.boom.web.service.UserService;
import org.boom.web.util.UrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

//    @Autowired
    private UserService userService = BoomServiceLocators.getUserService();

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "show";
    }

    @RequestMapping("/show")
    public String showVM(HttpServletRequest request, HttpServletResponse response, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        if (user == null) {
            try {
//                response.sendRedirect("../item/show");
                log.info("======serverUrl:" + UrlGenerator.getItemUrl());
                response.sendRedirect(UrlGenerator.getItemUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("user", user);
        return "user";
    }
}




