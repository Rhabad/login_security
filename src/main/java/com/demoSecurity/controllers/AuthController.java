package com.demoSecurity.controllers;

import com.demoSecurity.models.dto.AuthResponseDto;
import com.demoSecurity.models.dto.LoginRequestDto;
import com.demoSecurity.models.dto.RegisterRequestDto;
import com.demoSecurity.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> logueano(
            @RequestBody LoginRequestDto loginDto
    ) {
        return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponseDto> registrar(
            @RequestBody RegisterRequestDto registerDto
    ) {
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.OK);
    }
}
