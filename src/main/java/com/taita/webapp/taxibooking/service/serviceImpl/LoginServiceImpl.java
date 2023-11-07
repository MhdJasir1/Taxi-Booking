package com.taita.webapp.taxibooking.service.serviceImpl;

import com.taita.webapp.taxibooking.dto.LoginDTO;
import com.taita.webapp.taxibooking.entity.AdminUser;
import com.taita.webapp.taxibooking.repository.AdminUserRepository;
import com.taita.webapp.taxibooking.service.LoginService;
import com.taita.webapp.taxibooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AdminUserRepository adminUserRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean findByUsername(LoginDTO loginDTO) {
        AdminUser adminUser = adminUserRepository.findByUsername(loginDTO.getUsername());
        return adminUser != null && adminUser.getPassword().equals(loginDTO.getPassword());
    }

    public ResponseEntity<?> logIn(LoginDTO loginDTO) {
        Map<String, String> data = new HashMap<>();
        if(loginDTO.getUsername().equals("")){
            data.put("data","Please enter username");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
        }else if(loginDTO.getPassword().equals("")){
            data.put("data","Please enter password");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
        }else{
            AdminUser adminUser = adminUserRepository.findOneByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
            if (adminUser == null) {
                data.put("data","Invalid credentials!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
            }

            String token = jwtUtil.generateJwt(adminUser);
            data.put("data","success");
            data.put("userRole",adminUser.getRole());
            data.put("accessToken",token);

            return ResponseEntity.status(HttpStatus.OK).body(data);
        }
    }

//    public ResponseEntity<?> signUp(SignUpRequestDTO signUpRequestDTO) {
//        User user = new User();
//        user.setName(signUpRequestDTO.getName());
//        user.setEmail(signUpRequestDTO.getEmail());
//        user.setMobile(signUpRequestDTO.getMobile());
//        user.setPassword(signUpRequestDTO.getPassword());
//        user.setActive(Boolean.TRUE);
//        userRepository.save(user);
//
//        String token = jwtUtils.generateJwt(user);
//        Map<String, Object> data = new HashMap<>();
//        data.put("accessToken",token);
//
//        return ResponseEntity.status(HttpStatus.OK).body(data);
//
////        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully!");
//    }


}
