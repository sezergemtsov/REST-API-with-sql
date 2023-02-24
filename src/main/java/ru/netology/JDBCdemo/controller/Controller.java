package ru.netology.JDBCdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.JDBCdemo.service.Service;

@RestController
@RequestMapping("/")
public class Controller {

    Service service;

    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping("/products/fetch-product")
    public String fetchProduct(@RequestParam("name") String product) {
        return service.fetchProduct(product);
    }
}
