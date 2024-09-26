package com.kjh.musepicks.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String location;

    @NotNull
    private Long price;

    @NotBlank
    private String startDt;

    @NotNull
    private Long views;

    @NotBlank
    private String playTime;

    @NotNull
    private Long totalCount;

    @NotNull
    private Long reservedCount;

    @NotBlank
    private String description;
}
