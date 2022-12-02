package com.example.tokoonline.controller;

import com.example.tokoonline.model.Barang;
import com.example.tokoonline.model.TiketKereta;
import com.example.tokoonline.response.CommonResponse;
import com.example.tokoonline.response.ResponseHelper;
import com.example.tokoonline.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data-barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

//    post
    @PostMapping
    public CommonResponse<Barang> addBarang(@RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.addBarang(barang));
    }

//    get by id
    @GetMapping("/{id}")
    public CommonResponse<Barang> getBarangById(@PathVariable("id") Integer id) {

        return ResponseHelper.ok(barangService.getBarangById(id));
    }

//    get all
    @GetMapping("/all-barang")
    public CommonResponse<List<Barang>> getAllBarang() {
        return ResponseHelper.ok(barangService.getAllBarang());
    }

//    update
    @PutMapping("/{id}")
    public CommonResponse<Barang> updateBarang(@PathVariable("id") Integer id, @RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.updateBarang(id, barang.getName(), barang.getPrice(), barang.getCount(), barang.getReting(), barang.getDescription(), barang.getPublish()));
    }

//    delete
    @DeleteMapping("/{id}")
    public void deleteBarang(@PathVariable("id") Integer id) {
        barangService.deleteBarang(id);
}
}
