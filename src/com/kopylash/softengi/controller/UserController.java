package com.kopylash.softengi.controller;

import com.kopylash.softengi.entity.Address;
import com.kopylash.softengi.entity.Deposit;
import com.kopylash.softengi.entity.Employer;
import com.kopylash.softengi.entity.User;
import com.kopylash.softengi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by Владислав on 08.09.2015.
 */
@Controller
public class UserController {
    private static final String VIEW_INDEX = "index";
    private static final String VIEW_CREATE = "create";
    private static final String VIEW_EDIT = "edit";
    @Inject
    private UserService userService;

    @RequestMapping(value="/",method = {RequestMethod.GET,RequestMethod.HEAD})
    public String showAllUsers(ModelMap model) {
        model.addAttribute("userList",userService.getAllUsers());

        return VIEW_INDEX;
    }

    @RequestMapping(value="/create",method=RequestMethod.GET)
    public String createUser(ModelMap model) {
        User newUser=new User();
        newUser.setAddress(new Address());
        Deposit deposit = new Deposit();
        deposit.setUser(newUser);
        newUser.setDeposit(deposit);
        Employer employer = new Employer();
        employer.setAddress(new Address());
        newUser.setEmployer(employer);
        model.addAttribute("newUser",newUser);
        return VIEW_CREATE;
    }

    @RequestMapping(value="/createNewUser",method=RequestMethod.POST)
    public String createUser(@ModelAttribute("newUser") User newUser,BindingResult result,Model model) {
        userService.createUser(newUser);
        return "redirect:/";
    }

    @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
    public String editUser(@PathVariable("id") Integer id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user",user);
        return VIEW_EDIT;
    }

    @RequestMapping(value="edit/editUser",method=RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user,BindingResult result, ModelMap model) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}",method=RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
