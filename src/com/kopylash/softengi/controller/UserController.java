package com.kopylash.softengi.controller;

import com.kopylash.softengi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by Владислав on 08.09.2015.
 */
@Controller
public class UserController {
    private static final String VIEW_INDEX = "index";
    @Inject
    private UserService userService;

    @RequestMapping(value="/",method = {RequestMethod.GET,RequestMethod.HEAD})
    public String showAllUsers(ModelMap model) {
        model.addAttribute("userList",userService.getAllUsers());

        return VIEW_INDEX;
    }
}
