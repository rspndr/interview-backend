package io.rspndr.interview.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldRestController {

    @GetMapping(produces = "text/plain")
    public String sayHello() {
        return "Hello, World!";
    }
}
