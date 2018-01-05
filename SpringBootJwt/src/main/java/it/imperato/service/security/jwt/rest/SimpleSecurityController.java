package it.imperato.service.security.jwt.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.imperato.service.security.jwt.model.Authority;

@RestController
@RequestMapping("user")
public class SimpleSecurityController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public SimpleSecurityController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
       this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @RequestMapping("exists/{username}")
    public boolean userExists(@PathVariable("username") String username ) {
        return inMemoryUserDetailsManager.userExists(username);
    }

    @RequestMapping("add/{username}/{password}")
    public String add(@PathVariable("username") String username, @PathVariable("password") String password) {
        inMemoryUserDetailsManager.createUser(new User(username, password, new ArrayList<Authority>())); 
        return "added";
    }
    
}