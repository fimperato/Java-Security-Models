package it.imperato.service.security.jwt.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitTestController {
	
  @GetMapping("/hi")
  public String hello() {
    return "Init controller test!";
  }
  
}
