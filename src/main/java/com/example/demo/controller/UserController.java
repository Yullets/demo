package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String homePage(){
        return "user/dashboard";
    }
}
