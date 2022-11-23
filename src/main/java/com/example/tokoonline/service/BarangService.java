package com.example.tokoonline.service;

import com.example.tokoonline.model.Barang;

import java.util.List;

public interface BarangService {

//    post
    Barang addBarang(Barang barang);

//    get by id
    Barang getBarangById(Integer id);

//    get all
    List<Barang> getAllBarang();

//    update
    Barang updateBarang(Integer id, String name, Float price, Integer count, Integer reting, String description, Boolean publish);

//    delete
    void deleteBarang(Integer id);
}
