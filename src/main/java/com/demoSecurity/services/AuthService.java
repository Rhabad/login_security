package com.demoSecurity.services;

import com.demoSecurity.models.dao.UsuarioDao;
import com.demoSecurity.models.dto.AuthResponseDto;
import com.demoSecurity.models.dto.LoginRequestDto;
import com.demoSecurity.models.dto.RegisterRequestDto;
import com.demoSecurity.models.entities.Role;
import com.demoSecurity.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDto login(LoginRequestDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(), loginDto.getPassword())
        );

        UserDetails user = usuarioDao.findByUsername(loginDto.getUsername()).orElseThrow();

        String token = jwtService.getToken(user);

        return AuthResponseDto.builder()
                .token(token)
                .build();
    }

    public AuthResponseDto register(RegisterRequestDto registerDto) {
        Usuario usuario = Usuario.builder()
                .username(registerDto.getUsername())
                //encriptamos el password
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .firstname(registerDto.getFirstname())
                .lastname(registerDto.getLastname())
                .country(registerDto.getCountry())
                .role(Role.USER)
                .build();

        usuarioDao.save(usuario);

        return AuthResponseDto.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
