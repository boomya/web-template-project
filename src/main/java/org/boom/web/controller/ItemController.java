package org.boom.web.controller;

import org.boom.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangshan on 14/8/21.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @RequestMapping("/show")
    public String showVM(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("item", "test item");
        return "item";
    }
}
