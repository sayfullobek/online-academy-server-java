package it.UTeam.Onlinevideoacademyserverjava.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtErrors implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtErrors.class);
    private final HttpServletResponse httpServletResponse;

    public JwtErrors(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.error("Bu yo'lga kirish mumkin emas. Sababi " + e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

    }
}
