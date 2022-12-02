package com.example.tokoonline.service;

import com.example.tokoonline.model.OrderImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderImageService {
    OrderImage addOrderImage(Long orderId, MultipartFile multipartFile);

    List<OrderImage> getAllImg();
}
