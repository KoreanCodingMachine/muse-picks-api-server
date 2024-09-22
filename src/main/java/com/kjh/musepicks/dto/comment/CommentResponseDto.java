package com.kjh.musepicks.dto.comment;

import com.kjh.musepicks.domain.Account;
import com.kjh.musepicks.domain.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CommentResponseDto {
    private Long id;
    private String content;
    private String created_dt;
    private Long account_id;
    public static CommentResponseDto of (Comment comment) {
        return builder()
                .id(comment.getId())
                .content(comment.getContent())
                .created_dt(comment.getCreated_dt())
                .account_id(comment.getAccount().getId())
                .build();
    }
}
