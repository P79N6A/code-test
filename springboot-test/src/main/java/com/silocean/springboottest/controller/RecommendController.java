package com.silocean.springboottest.controller;

/**
 * Created by siyunfei on 2018/10/11.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {

    @RequestMapping("/hello")
    public Person index() {
        return new Person("xiaobai");
    }

}

class Person {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    String name;
}
