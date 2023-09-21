package com.example.network.aspect;

import com.example.network.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
        // 这里可以根据实际需求对异常进行处理
        int status = HttpStatus.BAD_REQUEST.value();
        String message = ex.getMessage();;

        // 构建自定义的ApiResponse并返回
        ApiResponse<Object> apiResponse = ApiResponse.error(status, message);
        return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(200));
    }
}
