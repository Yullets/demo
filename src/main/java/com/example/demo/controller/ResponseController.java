package com.example.demo.controller;

import com.example.demo.service.ConsumeResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Annotation
@Controller
@RequestMapping("/ConsumeResponse")

// Class
public class ResponseController {

    @GetMapping("/get") public String get(Model model)
    {
        // Creating object of ConsumeResponse class
        ConsumeResponse data = new ConsumeResponse();
        model.addAttribute("response",
                data.get().getBody());
        model.addAttribute("headers",
                data.get().getHeaders());

        return "output";
    }
}