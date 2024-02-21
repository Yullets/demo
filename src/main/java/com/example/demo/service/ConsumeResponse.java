package com.example.demo.service;

import com.example.demo.entity.DomainBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// Class
public class ConsumeResponse {

    // Creating an object of ResponseEntity class
    RestTemplate rest = new RestTemplate();

    public ResponseEntity<DomainBean> get()
    {

        return rest.getForEntity(
                "http://localhost:8080/JSON/{id}/{name}/{data}",
                DomainBean.class, "007", "geek@drash",
                "Darshan.G.Pawar");
    }
}