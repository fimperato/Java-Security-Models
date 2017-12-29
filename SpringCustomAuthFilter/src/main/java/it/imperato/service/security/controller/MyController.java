package it.imperato.service.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.imperato.service.security.model.MyObjectBody;

@Controller
@RequestMapping("/myservice")
public class MyController {
        
//        @Autowired
//        MyElaborationService myElaborationService;

        @RequestMapping(value = "list", method = RequestMethod.GET)
        public @ResponseBody List<MyObjectBody> listExchangeRates() {
        		List<MyObjectBody> list = new ArrayList<>();
        		list.add(new MyObjectBody());
                return list;
        }
                
}