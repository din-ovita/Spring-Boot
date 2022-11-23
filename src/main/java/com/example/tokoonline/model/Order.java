package com.example.tokoonline.model;

import com.example.tokoonline.auditing.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga")
    private String harga;

    @Column(name = "pemilik")
    private String pemilik;

    public Order() {
    }

    public Order(String namaBarang, String harga, String pemilik) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.pemilik = pemilik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", namaBarang='" + namaBarang + '\'' +
                ", harga="  + harga +
                ", pemilik='" + pemilik + '\'' +
                '}';
    }
}
