package com.chamo.chamowishes.dto.auth.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginRequestDTO {
    private String name;
    private String password;
}
