package com.example.tokoonline.service;

import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.BarangImage;
import com.example.tokoonline.model.Order;
import com.example.tokoonline.model.OrderImage;
import com.example.tokoonline.repository.OrderImageRepository;
import com.example.tokoonline.repository.OrderRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class OrderImageServiceImpl implements OrderImageService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderImageRepository orderImageRepository;

    @Override
    public OrderImage addOrderImage(Long orderId, MultipartFile multipartFile) {
        OrderImage addOrderImage = new OrderImage();
        addOrderImage.setOrderId(orderRepository.findById(Math.toIntExact(orderId)).get());
//        addImage.setBarangId(barangRepository.findById(barangId).get());
        addOrderImage.setImageOrder(confertToBase64(multipartFile));
        return orderImageRepository.save(addOrderImage);
    }

    @Override
    public List<OrderImage> getAllImg() {
        return orderImageRepository.findAll();
    }


    private String confertToBase64(MultipartFile file) {
        try {
            byte[] image = Base64.encodeBase64(file.getBytes());
            String result = new String(image);
            return ":data" + file.getContentType() + ";base64," + result;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
