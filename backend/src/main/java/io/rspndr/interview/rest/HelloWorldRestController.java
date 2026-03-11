package io.rspndr.interview.rest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldRestController {

    @GetMapping(produces = "text/plain")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("name")
    public ResponseEntity<String> sayHello(@RequestParam(required = false) String name) {
        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name is required");
        }

        return ResponseEntity.ok(String.format("Hello, %s!", name));
    }
}
