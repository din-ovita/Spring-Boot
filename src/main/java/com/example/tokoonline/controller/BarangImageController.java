package com.example.tokoonline.controller;

import com.example.tokoonline.model.BarangImage;
import com.example.tokoonline.service.BarangImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image")
public class BarangImageController {
    @Autowired
    BarangImageService barangImageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BarangImage addImage(@RequestPart("barangId") String barangId, @RequestPart("file") MultipartFile multipartFile) {
        return barangImageService.addImage(Integer.valueOf(barangId), multipartFile);
    }

    @GetMapping
    public List<BarangImage> findAll() {
        return barangImageService.findAll();
    }
}
