package com.example.tokoonline.jwt;

import com.example.tokoonline.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// yg diakses pertama kali oleh http service java, mengecek apakah token yg dimasukkan benar
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired // digunakan untuk memudahkan pemanggilan method
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request); // mengecek apakah token ada atau tidak
            if (token.isEmpty() && !jwtProvider.checkingTokenJwt(token)) return; //kondisi jika token tidak ditemukan, program berhenti
            String username = jwtProvider.getSubject(token); // mengecek eksitensi username
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header.isBlank() && !header.startsWith("Bearar ")) return null;
        return header.replace("Bearar ", "");
    }


//    throws : menunjukkan method bisa terjadi error, eror akan ditampilkan di file errror
//    if tanpa {}, digunakan untuk
}
