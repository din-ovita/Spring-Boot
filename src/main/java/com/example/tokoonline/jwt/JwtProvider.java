package com.example.tokoonline.jwt;

import com.google.api.client.util.Value;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    @Value("secret kode")
    private String secretKey;

    @Value("900000")
    private int expired;
// jwts
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) //nama token
                .setIssuedAt(new Date()) //tgl pembuataan
                .setExpiration(new Date(new Date().getTime() + expired)) //kadarluarsa
                .signWith(SignatureAlgorithm.HS512, secretKey) //menambahkan token, dan mengedit token (pembuatan token)
                .compact(); //penggabungan
    }

    public String getSubject(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    } //parser : dicoba ; parseClaimsJws : mencocokkan token ; getBody & getSubject: mengambil subject

    public boolean checkingTokenJwt(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token); //
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
