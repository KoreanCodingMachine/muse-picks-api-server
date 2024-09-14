package com.kjh.musepicks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiResponse {
    private Integer statusCode;
    private String message;

    public static ApiResponse of(ApiResponseCode responseCode) {
        return builder()
                .statusCode(responseCode.getStatusCode())
                .message(responseCode.getMessage())
                .build();
    }
}
