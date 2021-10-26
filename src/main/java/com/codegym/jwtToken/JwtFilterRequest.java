package com.codegym.jwtToken;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Kiet login 23/10 Filter to verify token or refresh token if expire
@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/public/login") || request.getServletPath().equals("/api/public/refresh/token")) {
            filterChain.doFilter(request, response);
        } else {
            String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
            System.out.println(authorization);
            if (authorization != null && authorization.startsWith("KIET ")) {
                try {
                    authorization = authorization.substring(5);
                    String username = jwtProvider.getUsernameFromToken(authorization);
                    UserDetails userDetail = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, userDetail.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage() + " JwtFilter");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    Map<String , String> errorsLog = new HashMap<>();
                    errorsLog.put("errors", ex.getMessage());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(),errorsLog);
                }
            }else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
