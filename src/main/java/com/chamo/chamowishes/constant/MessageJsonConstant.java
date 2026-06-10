package com.chamo.chamowishes.constant;

public class MessageJsonConstant {
    // Roles
    public static String ROLE_UNAUTHORIZED = "{\"error\": \"Rol unauthorized\"}";
    public static String ROLE_NOT_FOUND = "{\"error\": \"Rol not found\"}";

    // Token
    public static String TOKEN_INVALID = "{\"error\": \"Token is invalid or expired\"}";

    // Validation
    public static String HEADER_MISSING = "{\"error\": \"Header is missing in the request\"}";
    public static String VALIDATION_FAILED = "{\"error\": \"Validation failed\"}";
}
