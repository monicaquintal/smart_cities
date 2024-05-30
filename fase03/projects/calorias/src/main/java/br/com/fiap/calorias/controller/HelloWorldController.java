package br.com.fiap.calorias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHelloWorld(){
        return "Hello World! Spring Boot";
    }

    @GetMapping("/ola")
    public String getOlaMundo(){
        return "Olá mundo! Spring Boot";
    }

}