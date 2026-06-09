package com.chamo.chamowishes.enums;

import com.chamo.chamowishes.constant.MessageConstant;
import lombok.Getter;

@Getter
public enum UserRol {
    USER(1L),
    ADMIN(2L);

    private final Long id;

    UserRol(Long id) {
        this.id = id;
    }
}