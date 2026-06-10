package com.chamo.chamowishes.dto.auth.register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterRequestDTO {
    private String name;
    private String password;
}
