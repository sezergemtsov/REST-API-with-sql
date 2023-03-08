package ru.netology.JDBCdemo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ru.netology.JDBCdemo.model.Customers;
import ru.netology.JDBCdemo.model.Orders;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;


    public String getProductName(String name) {

        Query query = entityManager.createQuery("SELECT a.productName FROM Orders a INNER JOIN a.customer WHERE LOWER(a.customer.name) = :name");
        query.setParameter("name", name.toLowerCase());

        return query.getResultList().get(0).toString();
    }

    @Transactional
    public void fillCustomers() {

        List<Customers> customers = List.of(
                Customers.builder().name("Alexandr").surname("Alexandrov").age(31).phoneNumber("88115454").build(),
                Customers.builder().name("Alexey").surname("Alexandrov").age(21).phoneNumber("465464654").build(),
                Customers.builder().name("alexey").surname("Alexandrov").age(41).phoneNumber("456454654").build(),
                Customers.builder().name("Maxim").surname("Alexandrov").age(31).phoneNumber("88115454").build(),
                Customers.builder().name("ALEXEY").surname("Maximov").age(64).phoneNumber("544545454").build()
        );

        customers.forEach(x -> entityManager.persist(x));
    }

    @Transactional
    public void fillOrders() {

        List<Orders> orders = List.of(
                Orders.builder().productName("apple").dateOfOrder("08.03.2023").customer(entityManager.getReference(Customers.class, 1)).build(),
                Orders.builder().productName("orange").dateOfOrder("08.03.2023").customer(entityManager.getReference(Customers.class, 2)).build(),
                Orders.builder().productName("carrot").dateOfOrder("08.03.2023").customer(entityManager.getReference(Customers.class, 3)).build(),
                Orders.builder().productName("meat").dateOfOrder("08.03.2023").customer(entityManager.getReference(Customers.class, 4)).build(),
                Orders.builder().productName("onion").dateOfOrder("08.03.2023").customer(entityManager.getReference(Customers.class, 5)).build()
        );

        orders.forEach(x -> entityManager.persist(x));
    }

}
