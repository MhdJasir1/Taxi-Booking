package com.taita.webapp.taxibooking.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    @Autowired
//    LoginService loginService;

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody LoginDTO loginDTO){
//        return loginService.register(loginDTO);
//    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/driver")
    public String driver(){
        return "driver";
    }

}
