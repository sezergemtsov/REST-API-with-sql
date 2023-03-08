package ru.netology.JDBCdemo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ru.netology.JDBCdemo.model.Customer;
import ru.netology.JDBCdemo.model.Order;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;


    public String getProductName(String name) {

        String sqlRequest = String.format("select * from customers join orders on customers.id = orders.customer_id where LOWER(name) = '%s'", name);

        Query query = entityManager.createQuery("SELECT a.customer_id.name FROM Order a WHERE LOWER(a.customer_id.name) = :name");
        query.setParameter("name", name.toLowerCase());

        return query.getSingleResult().toString();
    }

    @Transactional
    public void fill() {

        List<Customer> customers = List.of(
                Customer.builder().name("Alexandr").surname("Alexandrov").age(31).phoneNumber("88115454").build(),
                Customer.builder().name("Alexey").surname("Alexandrov").age(21).phoneNumber("465464654").build(),
                Customer.builder().name("alexey").surname("Alexandrov").age(41).phoneNumber("456454654").build(),
                Customer.builder().name("Maxim").surname("Alexandrov").age(31).phoneNumber("88115454").build(),
                Customer.builder().name("ALEXEY").surname("Maximov").age(64).phoneNumber("544545454").build()
        );

        customers.forEach(x -> entityManager.persist(x));

        List<Order> orders = List.of(
                Order.builder().date("16.02.2023").productName("orange").amount(3).customer_id(entityManager.getReference(Customer.class, 1L)).build(),
                Order.builder().date("16.02.2023").productName("apple").amount(5).customer_id(entityManager.getReference(Customer.class, 2L)).build(),
                Order.builder().date("16.02.2023").productName("carrot").amount(4).customer_id(entityManager.getReference(Customer.class, 3L)).build(),
                Order.builder().date("16.02.2023").productName("meat").amount(2).customer_id(entityManager.getReference(Customer.class, 4L)).build(),
                Order.builder().date("16.02.2023").productName("paper").amount(1).customer_id(entityManager.getReference(Customer.class, 5L)).build()
        );

        orders.forEach(x -> entityManager.persist(x));


    }

}
