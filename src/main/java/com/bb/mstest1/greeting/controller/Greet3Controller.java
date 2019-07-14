package com.bb.mstest1.greeting.controller;

import com.bb.mstest1.greeting.domain.Customer;
import com.bb.mstest1.greeting.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Greet controller for customers:
 * Features:
 * <ul>
 *     <li>CRUD functionality for customers</li>
 *     <li>greet stored customers by their names based on ID</li>
 *     <li>in memory repository</li>
 * </ul>
 *
 * TODO:
 * <ul>
 *     <li>make customer repository thread safe</li>
 * </ul>
 */
@RestController
@RequestMapping(path = "/api", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@ConfigurationProperties(prefix="greet3")
public class Greet3Controller {


    @Autowired
    private CrudRepository<Customer, Integer> r;



    /**
     * http://localhost:9090/api/customers
     * @return
     */
    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        List<Customer> copy = new ArrayList<>();
        r.findAll().forEach(c -> copy.add(c));
        return copy;
    }

    /**
     * http://localhost:9090/api/customers/{id}
     * @return
     */
    @GetMapping(path = "/customers/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return r.findById(id).get();
    }

    /**
     * http://localhost:9090/api/customers?title=XXX&name=YYY
     * @return
     */
    @PostMapping(value = "/customers")
    public Customer addCustomer(@RequestParam(value="title") String title, @RequestParam(value="name") String name) {
        Customer c = r.save(new Customer(title, name));
        return c;
    }

    /**
     * http://localhost:9090/api/customers?title=XXX&name=YYY
     * @return
     */
    @DeleteMapping(value = "/customers")
    public String addCustomer(@RequestParam(value="id") int id) {
        r.deleteById(id);
        return "";
    }

    /**
     * http://localhost:9090/api/customers/{id}
     * @return
     */
    @GetMapping(path = "/greet31/{id}")
    public String greet31(@PathVariable Integer id) {
        Customer c = r.findById(id).get();
        return "{ \"greeting\": \"Hello " + c.getTitle() + " " + c.getName() + "\"}";
    }

    /**
     * http://localhost:9090/api/customers/{id}
     * @return
     */
    @PostMapping(path = "/greet32")
    public String greet32(int id) {
        Customer c = r.findById(id).get();
        return "{ \"greeting\": \"Hello " + c.getTitle() + " " + c.getName() + "\"}";
    }
}

