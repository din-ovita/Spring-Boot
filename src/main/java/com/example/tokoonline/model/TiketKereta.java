package com.example.tokoonline.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalTime;

import javax.persistence.*;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "tiket_kereta")
public class TiketKereta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nama;

    @Column(name = "krl")
    private String krl;

    @Column(name = "departure")
    private String departure;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "start_date", updatable = false)
    private Date startDate;

    @Column(name = "kode_bocking")
    private String kodeBocking;

    @Column(name = "end_departure")
    private String endDeparture;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "pasagger_type")
    private PasaggerType pasaggerType;

    public TiketKereta() {
    }

    public TiketKereta(String nama, String krl, String departure, Date startDate, String kodeBocking, String endDeparture, Date end_date, PasaggerType pasaggerType) {
        this.nama = nama;
        this.krl = krl;
        this.departure = departure;
        this.startDate = startDate;
        this.kodeBocking = kodeBocking;
        this.endDeparture = endDeparture;
        this.end_date = end_date;
        this.pasaggerType = pasaggerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKrl() {
        return krl;
    }

    public void setKrl(String krl) {
        this.krl = krl;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getKodeBocking() {
        return kodeBocking;
    }

    public void setKodeBocking(String kodeBocking) {
        this.kodeBocking = kodeBocking;
    }

    public String getEndDeparture() {
        return endDeparture;
    }

    public void setEndDeparture(String endDeparture) {
        this.endDeparture = endDeparture;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public PasaggerType getPasaggerType() {
        return pasaggerType;
    }

    public void setPasaggerType(PasaggerType pasaggerType) {
        this.pasaggerType = pasaggerType;
    }
}
