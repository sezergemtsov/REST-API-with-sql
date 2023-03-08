package ru.netology.JDBCdemo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public String getProductName(String name) {

        Query query = entityManager.createQuery("SELECT a.productName FROM Orders a INNER JOIN a.customer WHERE LOWER(a.customer.name) = :name");
        query.setParameter("name", name.toLowerCase());

        return query.getResultList().get(0).toString();
    }

}
