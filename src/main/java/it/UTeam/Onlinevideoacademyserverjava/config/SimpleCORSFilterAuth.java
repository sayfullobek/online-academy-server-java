package it.UTeam.Onlinevideoacademyserverjava.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import io.jsonwebtoken.Jwts;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class SimpleCORSFilterAuth extends CorsFilter {

    @Value("${app.jwtSecretKey}")
    private String key;


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Methods,Access-Control-Allow-Origin,x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");

        String authorization = response.getHeader("Authorization");
        String userId = getUserIdToken(authorization);

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            try {
                if (!resp.isCommitted()) {
                    chain.doFilter(req, resp);
                }
            } catch (IOException | ServletException e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
            }
        }
    }

    public String getUserIdToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}