package com.bb.mstest1.greeting.controller;

import com.bb.mstest1.greeting.domain.Greeting;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/api", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@ConfigurationProperties(prefix="greet2")
public class Greet2Controller {



    private final AtomicLong counter = new AtomicLong();


    /**
     * Stateful greeting for anyone.
     * State: number of stateful greetings so far (stored in memory)
     * http://localhost:9090/api/greet2
     * @return
     */
    @GetMapping(value = "/greet21")
    public Map<String, Object> greet2() {
        Map<String, Object> response = new HashMap<>();
        response.put("id", counter.get());
        response.put("content", "Hi");
        return response;
    }


    /**
     * Stateful greeting for a person. (Name is optional)
     * http://localhost:9090/api/greet3
     * http://localhost:9090/api/greet3?name=John
     * @return ""
     */
    @GetMapping(value = "/greet22")
    public Greeting greet3(@RequestParam(value="name", defaultValue="Mr./Ms./Mrs./Miss") String name) {
        return new Greeting(counter.get(), "Hello, " + name);
    }

    /**
     * http://localhost:9090/api/greet4
     * http://localhost:9090/api/greet4?name=John
     * @return ""
     */
    @PostMapping(value = "/greet24")
    public Greeting greet4(String name) {
        System.out.println("Called \"greet4\" with: " + name);
        if (name==null)
            return new Greeting(counter.incrementAndGet(), "Hello, Mr./Ms./Mrs./Miss");
        return new Greeting(counter.incrementAndGet(), "Hello, " + name);
    }
}

