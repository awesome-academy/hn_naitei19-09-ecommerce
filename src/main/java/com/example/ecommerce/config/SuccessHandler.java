package com.example.ecommerce.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", userDetails);
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst().get();
        if (roles.equals("ADMIN")) {
            response.sendRedirect("/admin/orders/");
        } else if (roles.equals("USER")) {
            response.sendRedirect("/");
        }
    }

}



