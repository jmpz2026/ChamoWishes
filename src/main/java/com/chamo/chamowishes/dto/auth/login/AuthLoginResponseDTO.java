package com.chamo.chamowishes.dto.auth.login;

import com.chamo.chamowishes.dto.TokenDataDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginResponseDTO {
    private String name;
    private String token;
}
