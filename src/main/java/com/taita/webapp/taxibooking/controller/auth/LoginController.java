package com.taita.webapp.taxibooking.controller.auth;

import com.taita.webapp.taxibooking.dto.LoginDTO;
import com.taita.webapp.taxibooking.dto.RequestMetaDTO;
import com.taita.webapp.taxibooking.service.serviceImpl.LoginServiceImpl;
import com.taita.webapp.taxibooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    LoginServiceImpl loginServiceImpl;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    RequestMetaDTO requestMetaDTO;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginResponse(@RequestBody LoginDTO loginDTO){
        return loginServiceImpl.logIn(loginDTO);
    }
    @GetMapping("/privateApi")
    public ResponseEntity<?> privateApi(@RequestHeader(value = "Authorization",defaultValue = "") String auth) throws Exception {
        jwtUtil.verify(auth);
        System.out.println(requestMetaDTO.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body("this is private api");
    }

}
