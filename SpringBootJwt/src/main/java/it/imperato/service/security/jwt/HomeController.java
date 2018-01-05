package it.imperato.service.security.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HomeController {
	
    @RequestMapping("/homepage")
    public String index(@RequestParam(value="name", required=false, defaultValue="my-def-value") String name, Model model) {
        return "homepage";
    }
}

