package com.example.tokoonline.dto;

public class OrderDTO {
    private String namaBarang;
    private String harga;
    private String pemilik;

    public OrderDTO() {
    }

    public OrderDTO(String namaBarang, String harga, String pemilik) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.pemilik = pemilik;
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
        return "OrderDTO{" +
                "namaBarang='" + namaBarang + '\'' +
                ", harga='" + harga + '\'' +
                ", pemilik='" + pemilik + '\'' +
                '}';
    }
}
