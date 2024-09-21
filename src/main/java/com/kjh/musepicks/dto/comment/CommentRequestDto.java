package com.kjh.musepicks.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    @NotBlank
    private String content;

    @NotBlank
    private String nickname; // 혹은 유저 권한? 정보..

}
