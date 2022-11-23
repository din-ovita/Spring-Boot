package com.example.tokoonline.service;

import com.example.tokoonline.exception.EmailCondition;
import com.example.tokoonline.exception.InternalErrorException;
import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.Order;
import com.example.tokoonline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        if (orderRepository.findByPemilik(order.getPemilik()).isPresent()) {
            throw new EmailCondition("Email already exist");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memasukkan data");
        }
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Integer id, String namaBarang, String harga, String pemilik) {
        Order order = orderRepository.findById(id).get();
        order.setHarga(harga);
        order.setNamaBarang(namaBarang);
        order.setPemilik(pemilik);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
