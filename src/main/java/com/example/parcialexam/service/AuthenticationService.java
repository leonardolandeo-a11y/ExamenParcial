package com.example.parcialexam.service;

import com.example.parcialexam.dto.LoginRequestDTO;
import com.example.parcialexam.dto.LoginResponseDTO;
import com.example.parcialexam.dto.UserResponseDTO;
import com.example.parcialexam.dto.UserResquestDTO;
import com.example.parcialexam.exceptions.UserAlreadyExistsException;
import com.example.parcialexam.model.Role;
import com.example.parcialexam.model.User;
import com.example.parcialexam.repository.UserRepository;
import com.example.parcialexam.security.JwtService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    public UserResponseDTO register(UserResquestDTO userResquestDTO){
        if (userRepository.existsByUsername(userResquestDTO.getUsername())){
            throw new UserAlreadyExistsException("User already exists");
        }
        User user = modelMapper.map(userResquestDTO,User.class);
        user.setPassword(passwordEncoder.encode(userResquestDTO.getPassword()));
        user.setRole(Role.ROLE_PASSENGER);
        User userSaved = userRepository.save(user);
        String token = jwtService.generateToken(userSaved);
        Long expiresIn = jwtService.extractExpires(token);

        return new UserResponseDTO(userSaved.getId(),userSaved.getUsername(), userSaved.getUsername());
    }
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        User user = userRepository.findByUsername(loginRequestDTO.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        Long expiresIn = jwtService.extractExpires(token);

        return new LoginResponseDTO(token,expiresIn);
    }
}
