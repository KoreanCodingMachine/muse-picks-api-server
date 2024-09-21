package com.kjh.musepicks.dto.post;

import com.kjh.musepicks.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private String title;
    private String start_dt;
    private Long views;

    // 이미지 , 카테고리

    public static PostResponseDto of (Post post) {
        return builder()
                .title(post.getTitle())
                .start_dt(post.getStart_dt())
                .views(post.getViews())
                .build();
    }
}
