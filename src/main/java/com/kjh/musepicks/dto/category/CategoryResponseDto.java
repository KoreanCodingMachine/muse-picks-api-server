package com.kjh.musepicks.dto.category;

import com.kjh.musepicks.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponseDto {
    private Long id;
    private String name;

    public static CategoryResponseDto of(Category category) {
        return builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
