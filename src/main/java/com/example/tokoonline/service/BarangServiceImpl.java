package com.example.tokoonline.service;

import com.example.tokoonline.exception.InternalErrorException;
import com.example.tokoonline.exception.NotFoundException;
import com.example.tokoonline.model.Barang;
import com.example.tokoonline.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangServiceImpl implements BarangService{

    @Autowired
    BarangRepository barangRepository;

//    post
    @Override
    public Barang addBarang(Barang barang) {
        try {
            return barangRepository.save(barang);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memasukkan data");
        }
    }

//    get by id
    @Override
    public Barang getBarangById(Integer id) {
        try {
            return barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memasukkan data");
        }
    }

//    get all
    @Override
    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

//    update
    @Override
    public Barang updateBarang(Integer id, String name, Float price, Integer count, Integer reting, String description, Boolean publish) {
        try {
            Barang barang = barangRepository.findById(id).get();
            barang.setName(name);
            barang.setPrice(price);
            barang.setCount(count);
            barang.setReting(reting);
            barang.setDescription(description);
            barang.setPublish(publish);
            return barangRepository.save(barang);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memasukkan data");
        }
    }

//    delete

    @Override
    public void deleteBarang(Integer id) {
        barangRepository.deleteById(id);
    }
}
