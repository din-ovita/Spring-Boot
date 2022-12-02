package com.example.tokoonline.controller;

import com.example.tokoonline.model.BarangImage;
import com.example.tokoonline.model.OrderImage;
import com.example.tokoonline.service.OrderImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image-order")
public class OrderImageController {
    @Autowired
    OrderImageService orderImageService;

    @PostMapping(consumes = "multipart/form-data")
    public OrderImage addOrderImage(@RequestPart("orderId") String orderId, @RequestPart("file") MultipartFile multipartFile) {
        return orderImageService.addOrderImage(Long.valueOf(orderId), multipartFile);
    }

    @GetMapping
    public List<OrderImage> getAllImg() {
        return orderImageService.getAllImg();
    }
}
