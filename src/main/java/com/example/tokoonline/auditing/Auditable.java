package com.example.tokoonline.auditing;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {

//    json format
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
//    to menampung keterangan waktu skrng
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

//    format GMT 0, pusat dunia, London
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
//    perubahan data : terakhir di update
    @LastModifiedDate
    @Column(name = "update_at")
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
