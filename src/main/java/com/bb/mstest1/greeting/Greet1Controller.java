package com.bb.mstest1.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="greet1")
public class Greet1Controller {



    private final AtomicLong counter = new AtomicLong();


    /**
     * http://localhost:9090/api/greet1
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/greet1", produces = "text/plain")
    public String greet1() {
        return "{ \"id\": " + counter.incrementAndGet() + " , \"greet\": \"Hello\" }";
    }

    /**
     * http://localhost:9090/api/greet2
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/greet2")
    public Greeting greet2() {
        return new Greeting(counter.incrementAndGet(), "Hi");
    }


    /**
     * http://localhost:9090/api/greet3
     * http://localhost:9090/api/greet3?name=John
     * @return ""
     */
    @RequestMapping(method = RequestMethod.GET, value = "/greet3")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Mr./Ms./Mrs./Miss") String name) {
        return new Greeting(counter.incrementAndGet(), "Hello, " + name);
    }
}


