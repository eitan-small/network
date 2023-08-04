package com.example.network.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 可选：定义静态方法，便于创建不同状态的响应实体
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    public static ApiResponse<Object> error(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }
}
