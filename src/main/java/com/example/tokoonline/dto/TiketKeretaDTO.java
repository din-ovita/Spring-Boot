package com.example.tokoonline.dto;

import com.example.tokoonline.model.PasaggerType;

public class TiketKeretaDTO {
    private String nama;
    private String krl;
    private String departure;
    private String endDeparture;

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

    public String getEndDeparture() {
        return endDeparture;
    }

    public void setEndDeparture(String endDeparture) {
        this.endDeparture = endDeparture;
    }

}
