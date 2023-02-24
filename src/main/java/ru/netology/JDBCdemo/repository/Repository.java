package ru.netology.JDBCdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.netology.JDBCdemo.model.Order;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public String getProductName(String name) {

        String sqlRequest = String.format("select * from customers join orders on customers.id = orders.customer_id where LOWER(name) = '%s'", name);

        List<Order> orders = jdbcTemplate.query(sqlRequest, (rs, rowNum) -> new Order(
                rs.getInt("id"),
                rs.getString("date"),
                rs.getInt("customer_id"),
                rs.getString("product_name"),
                rs.getInt("amount")));

        return orders.get(0).productName();
    }

}
