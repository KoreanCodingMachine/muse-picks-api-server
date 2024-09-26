package com.kjh.musepicks.handler;

import com.kjh.musepicks.dto.ApiResponse;
import com.kjh.musepicks.dto.ApiResponseCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundException {
    @ExceptionHandler(value = jakarta.persistence.EntityNotFoundException.class)
    public ApiResponse handleException() {
        return ApiResponse.of(ApiResponseCode.POST_NOT_FOUND);
    }
}
