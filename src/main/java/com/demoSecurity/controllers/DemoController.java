package com.demoSecurity.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
public class DemoController {

    @PostMapping("hola")
    public String hola(){
        return "hola a todos";
    }
}
