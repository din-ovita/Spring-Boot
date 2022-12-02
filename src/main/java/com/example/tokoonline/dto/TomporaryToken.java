package com.example.tokoonline.dto;

import com.example.tokoonline.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.api.client.util.Data;

public class TomporaryToken {

    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Data expiredDate;

    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Data getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Data expiredDate) {
        this.expiredDate = expiredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
