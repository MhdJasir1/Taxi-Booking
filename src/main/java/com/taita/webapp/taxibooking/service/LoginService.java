package com.taita.webapp.taxibooking.service;

import com.taita.webapp.taxibooking.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface LoginService {
    boolean findByUsername(LoginDTO loginDTO);

}
