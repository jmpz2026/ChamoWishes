package com.chamo.chamowishes.service;

import com.chamo.chamowishes.constant.MessageConstant;
import com.chamo.chamowishes.dto.ApiResponseDTO;
import com.chamo.chamowishes.dto.TokenDataDTO;
import com.chamo.chamowishes.dto.auth.login.AuthLoginRequestDTO;
import com.chamo.chamowishes.dto.auth.login.AuthLoginResponseDTO;
import com.chamo.chamowishes.dto.auth.register.AuthRegisterRequestDTO;
import com.chamo.chamowishes.dto.auth.register.AuthRegisterResponseDTO;
import com.chamo.chamowishes.entity.AppUserEntity;
import com.chamo.chamowishes.enums.UserRol;
import com.chamo.chamowishes.exception.ResourceExistsException;
import com.chamo.chamowishes.exception.ResourceNotFoundException;
import com.chamo.chamowishes.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final JwtService jwtService;

    public ApiResponseDTO<AuthRegisterResponseDTO> register(AuthRegisterRequestDTO authRegisterRequestDTO) {
        if(appUserRepository.existsByName(authRegisterRequestDTO.getName())){
            throw new ResourceExistsException(MessageConstant.USER_ALREADY_REGISTERED);
        }

        Long idDefault = 1L;

        AppUserEntity appUserEntity = new AppUserEntity();
        appUserEntity.setName(authRegisterRequestDTO.getName());
        appUserEntity.setPassword(authRegisterRequestDTO.getPassword());
        appUserEntity.setRolId(1L);
        appUserRepository.save(appUserEntity);

        String token = jwtService.generateToken(appUserEntity.getId(),idDefault,appUserEntity.getName());

        AuthRegisterResponseDTO authRegisterResponseDTO = new AuthRegisterResponseDTO();
        authRegisterResponseDTO.setName(authRegisterRequestDTO.getName());
        authRegisterResponseDTO.setToken(token);

        ApiResponseDTO<AuthRegisterResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(authRegisterResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.USER_REGISTERED);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }

    public ApiResponseDTO<AuthLoginResponseDTO> login(AuthLoginRequestDTO authLoginRequestDTO) {
        AppUserEntity appUserEntity = appUserRepository.findByName(authLoginRequestDTO.getName())
                .orElseThrow(() -> new ResourceNotFoundException(MessageConstant.USER_NOT_FOUND));

        String token = jwtService.generateToken(appUserEntity.getId(),appUserEntity.getRolId(),appUserEntity.getName());

        AuthLoginResponseDTO authLoginResponseDTO = new AuthLoginResponseDTO();
        authLoginResponseDTO.setName(authLoginRequestDTO.getName());
        authLoginResponseDTO.setToken(token);

        ApiResponseDTO<AuthLoginResponseDTO> apiResponseDTO = new ApiResponseDTO<>();
        apiResponseDTO.setData(authLoginResponseDTO);
        apiResponseDTO.setMessage(MessageConstant.USER_LOGGED);
        apiResponseDTO.setSuccess(true);
        return apiResponseDTO;
    }
}
