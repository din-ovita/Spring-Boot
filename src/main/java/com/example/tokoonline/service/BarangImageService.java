package com.example.tokoonline.service;

import com.example.tokoonline.model.BarangImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BarangImageService {

    BarangImage addImage(int barangId, MultipartFile multipartFile);

    List<BarangImage> findAll();


}
