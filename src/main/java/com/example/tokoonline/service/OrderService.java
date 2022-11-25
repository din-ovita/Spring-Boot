package com.example.tokoonline.service;

import com.example.tokoonline.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    Order getOrderById(Integer id);

    Order updateOrder(Integer id, String namaBarang, String harga);

    List<Order> getAllOrder();

    void deleteOrder(Integer id);
}
