package com.example.tokoonline.controller;

import com.example.tokoonline.dto.OrderDTO;
import com.example.tokoonline.model.Order;
import com.example.tokoonline.response.ResponseHelper;
import com.example.tokoonline.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data-order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO) {
        return ResponseHelper.ok(orderService.addOrder(modelMapper.map(orderDTO, Order.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Integer id) {
        return ResponseHelper.ok(orderService.getOrderById(id));
    }

    @GetMapping("/all-order")
    public ResponseEntity<?> getAllOrder() {
        return ResponseHelper.ok(orderService.getAllOrder());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Integer id, @RequestBody Order order ) {
        return ResponseHelper.ok(orderService.updateOrder(id, order.getNamaBarang(), order.getHarga()));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
    }
}
