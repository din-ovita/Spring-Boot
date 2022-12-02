package com.example.tokoonline.model;

import javax.persistence.*;

@Entity
@Table(name = "order_image")
public class OrderImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_order")
    private String imageOrder;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    public OrderImage() {
    }

    public OrderImage(String imageOrder, Order orderId) {
        this.imageOrder = imageOrder;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(String imageOrder) {
        this.imageOrder = imageOrder;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }
}
