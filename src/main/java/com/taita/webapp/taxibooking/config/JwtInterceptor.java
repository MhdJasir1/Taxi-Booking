package com.taita.webapp.taxibooking.config;

import com.taita.webapp.taxibooking.dto.RequestMetaDTO;
import com.taita.webapp.taxibooking.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    private RequestMetaDTO requestMetaDTO;

    public JwtInterceptor(RequestMetaDTO requestMetaDTO){
        this.requestMetaDTO = requestMetaDTO;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String auth = request.getHeader("authorization");
//
//        if(!(request.getRequestURI().contains("auth/") || request.getRequestURI().contains("assets/"))){
//            Claims claims = jwtUtil.verify(auth);
//            requestMetaDTO.setAdminUserId(Integer.parseInt(claims.getIssuer()));
//            requestMetaDTO.setUsername(claims.get("username").toString());
//        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
