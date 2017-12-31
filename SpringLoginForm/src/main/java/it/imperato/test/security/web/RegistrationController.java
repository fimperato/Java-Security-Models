package it.imperato.test.security.web;

import it.imperato.test.security.components.UserPasswordEncoder;
import it.imperato.test.security.model.Users;
import it.imperato.test.security.service.UsersManager;
import it.imperato.test.security.validation.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    UsersManager usersManager;

    @Autowired
    UserPasswordEncoder userPasswordEncoder;

    @Autowired
    UserValidator userValidator;



    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signUp(@ModelAttribute("newUser")Users users,BindingResult bindingResult){
        userValidator.validate(users,bindingResult);

        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.toString());
            return "signin";
        }
        userPasswordEncoder.encodePassword(users);
        usersManager.createNewUser(users);
        return "redirect:/signin";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signUp(Model map){
        map.addAttribute("newUser",new Users());
        return "signin";
    }




}
