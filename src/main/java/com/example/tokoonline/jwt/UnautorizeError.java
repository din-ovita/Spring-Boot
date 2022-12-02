package com.example.tokoonline.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//data object di response
@Component
public class UnautorizeError implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.resetBuffer(); //mengosongkan response(default) sebelumnya
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // merubah status seperti httpStatus.NOT_FOUND
        response.setHeader("Content-Type", "application/json"); // memunculkan objek di javascript
        response.getOutputStream().print("{\n" +  //response error yg muncul
                "\"status\": 401,\n," +
                "\"message\": \"Unautorized\", \n" +
                "\"error\": \"Need token for access API\", \n" +
                "}");
        response.resetBuffer();
    }
}

//
