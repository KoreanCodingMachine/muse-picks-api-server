package com.kjh.musepicks.dto.post;

import com.kjh.musepicks.domain.Post;
import com.kjh.musepicks.domain.PostCategory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponseDto {
    private String title;
    private String start_dt;
    private Long views;
    private List<String> categories;

    public static PostResponseDto of (Post post) {

        List<String> categoryNames = post.getPostCategories().stream()
                .map(postCategory -> postCategory.getCategory().getName())
                .toList();

        return builder()
                .title(post.getTitle())
                .start_dt(post.getStart_dt())
                .views(post.getViews())
                .categories(categoryNames)
                .build();
    }

}
