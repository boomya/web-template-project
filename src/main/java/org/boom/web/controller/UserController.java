package org.boom.web.controller;

import org.apache.log4j.Logger;
import org.boom.web.BoomServiceLocators;
import org.boom.web.domain.User;
import org.boom.web.service.UserService;
import org.boom.web.util.UrlGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    //    @Autowired
    private UserService userService = BoomServiceLocators.getUserService();

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletResponse response, Model model){
        return showVMRest(response, model, 1);
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String index2(){
        return "redirect:show/1";
    }

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "show";
    }

    @RequestMapping(value = {"/show", "/showUser"})
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

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showVMRest(HttpServletResponse response, Model model,
                             @PathVariable("id") int id) {
        User user = this.userService.getUserById(id);
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

    @RequestMapping("/getJSON/{id}")
    public @ResponseBody Object getJSON(Model model, @PathVariable("id") int userId){
        User user = this.userService.getUserById(userId);
        model.addAttribute(user);
        return model;
    }
}




