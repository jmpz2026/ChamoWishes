package com.chamo.chamowishes.enums;

import com.chamo.chamowishes.constant.MessageConstant;
import com.chamo.chamowishes.exception.ResourceNotFoundException;
import lombok.Getter;

@Getter
public enum UserRol {
    USER(1L),
    ADMIN(2L);

    private final Long id;

    UserRol(Long id) {
        this.id = id;
    }

    public static String getById(Long id) {
        for (UserRol userRol : UserRol.values()) {
            if (userRol.getId().equals(id)) {
                return userRol.name();
            }
        }
        throw new ResourceNotFoundException(MessageConstant.ROLE_NOT_FOUND);
    }
}