package com.kjh.musepicks.dto.postCategory;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCategoryRequestDto {
    @NotNull
    private Long postId;

    @NotNull
    private Long categoryId;
}
