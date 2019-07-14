package com.bb.mstest1.greeting.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@ConfigurationProperties(prefix="greet1")
public class Greet1Controller {




    /**
     * Stateless greeting for anyone.
     * http://localhost:9090/api/greet1
     * @return
     */
    @GetMapping(value = "/greet11")
    public String greet1() {
        return "{ \"greet\": \"Hello\" }";
    }
}

