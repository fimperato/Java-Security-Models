package it.imperato.test.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserAccountController {


    @RequestMapping(value = "/accountPage",method = RequestMethod.GET)
    public String getAccountPage(Model map,Principal principal){

        return null;
    }

}
