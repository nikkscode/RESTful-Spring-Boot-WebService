package com.nikkmuc.rest.webservice.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControler {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
