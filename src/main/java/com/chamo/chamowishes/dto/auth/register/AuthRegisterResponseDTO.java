package com.chamo.chamowishes.dto.auth.register;

import com.chamo.chamowishes.dto.TokenDataDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterResponseDTO {
    private String name;
    private String token;
}
