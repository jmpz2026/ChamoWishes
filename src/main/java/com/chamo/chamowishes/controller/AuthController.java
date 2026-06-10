package com.chamo.chamowishes.controller;

import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.auth.login.AuthLoginRequestDTO;
import com.chamo.chamowishes.dto.auth.login.AuthLoginResponseDTO;
import com.chamo.chamowishes.dto.auth.register.AuthRegisterRequestDTO;
import com.chamo.chamowishes.dto.auth.register.AuthRegisterResponseDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetRequestDTO;
import com.chamo.chamowishes.dto.product.get.ProductGetResponseDTO;
import com.chamo.chamowishes.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PutMapping
    public ResponseEntity<ApiResponseDTO<AuthRegisterResponseDTO>> register(@RequestBody AuthRegisterRequestDTO authRegisterRequestDTO) {
        ApiResponseDTO<AuthRegisterResponseDTO> apiResponseDTO = authService.register(authRegisterRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseDTO);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<AuthLoginResponseDTO>> login(@RequestBody AuthLoginRequestDTO authLoginRequestDTO) {
        ApiResponseDTO<AuthLoginResponseDTO> apiResponseDTO = authService.login(authLoginRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseDTO);
    }
}
