package com.example.parcialexam.controller;

import com.example.parcialexam.dto.LoginRequestDTO;
import com.example.parcialexam.dto.LoginResponseDTO;
import com.example.parcialexam.dto.UserResponseDTO;
import com.example.parcialexam.dto.UserResquestDTO;
import com.example.parcialexam.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserResquestDTO userResquestDTO){
        UserResponseDTO userResponseDTO = authenticationService.register(userResquestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);

    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@Valid @RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO loginResponseDTO = authenticationService.login(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponseDTO);
    }
}
