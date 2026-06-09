package com.chamo.chamowishes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDTO<T> {
    private Boolean success;
    private String message;
    private T data;
}
