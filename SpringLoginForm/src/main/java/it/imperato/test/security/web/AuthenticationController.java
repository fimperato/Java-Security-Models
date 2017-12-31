package it.imperato.test.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.imperato.test.security.model.Users;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public String login(Model map){
		map.addAttribute("newUser",new Users());
		return "signin";
	}

	@RequestMapping(value = "/j_spring_security_logout",method = RequestMethod.GET)
	public String logout(){
//		return "redirect:/j_spring_security_logout";
		return "redirect:/logout";
	}

}
