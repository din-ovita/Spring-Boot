package com.example.tokoonline.model;

import com.example.tokoonline.auditing.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "barang")
public class Barang extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "count")
    private Integer count = 0;

    @Column(name = "reting")
    private Integer reting;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "publish", nullable = false)
    private Boolean publish;

    public Barang() {
    }

    public Barang(String name, Float price, Integer count, Integer reting, String description, Boolean publish) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.reting = reting;
        this.description = description;
        this.publish = publish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getReting() {
        return reting;
    }

    public void setReting(Integer reting) {
        this.reting = reting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", reting=" + reting +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                '}';
    }
}
