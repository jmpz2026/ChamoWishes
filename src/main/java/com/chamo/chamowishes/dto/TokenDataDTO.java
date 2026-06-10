package com.chamo.chamowishes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDataDTO {
    private String username;
    private Long rolId;
    private String role;
}