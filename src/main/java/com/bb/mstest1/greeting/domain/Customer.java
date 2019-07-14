package com.bb.mstest1.greeting.domain;

public class Customer {

    private final Integer id;
    private final String title;
    private final String name;


    public Customer(String title, String name) {
        this(-1, title, name);
    }

    public Customer(int id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getName() {
        return this.name;
    }
}