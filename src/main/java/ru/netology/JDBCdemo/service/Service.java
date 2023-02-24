package ru.netology.JDBCdemo.service;

import ru.netology.JDBCdemo.repository.Repository;

@org.springframework.stereotype.Service
public class Service {

    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String fetchProduct(String product) {
        return repository.getProductName(product);
    }
}
