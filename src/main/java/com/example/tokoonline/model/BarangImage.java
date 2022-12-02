package com.example.tokoonline.model;

import javax.persistence.*;

@Entity
@Table(name = "barang_image")
public class BarangImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_url")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    private Barang barangId;

    public BarangImage() {
    }

    public BarangImage(String imageURL, Barang barangId) {
        this.imageURL = imageURL;
        this.barangId = barangId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Barang getBarangId() {
        return barangId;
    }

    public void setBarangId(Barang barangId) {
        this.barangId = barangId;
    }
}
