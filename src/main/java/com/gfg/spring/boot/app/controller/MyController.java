package com.gfg.spring.boot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    // Home page html from hard-coded text
    @GetMapping(path = "/gfg")
    @ResponseBody
    public String home() {
        return """
                <html><body>
                <font color="green">
                    <h1><a href="https://www.geeksforgeeks.org/dynamic-dropdown-from-database-using-spring-boot/">Dynamic Dropdown From Database using Spring Boot</a></h1>
                </font>
                </body></html>
                """;
    }

    @GetMapping(path = "/gfg/description")
    @ResponseBody
    public String info() {
        return """
                <html><body>
                <font color="green">
                GeeksForGeeks is a Computer Science portal for Geeks. long description here :).
                </font>
                </body></html>
                """;
    }
}
