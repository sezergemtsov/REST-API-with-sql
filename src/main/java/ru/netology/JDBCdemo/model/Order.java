package ru.netology.JDBCdemo.model;

public record Order(int id, String date, int customerId, String productName, int amount) {
}
