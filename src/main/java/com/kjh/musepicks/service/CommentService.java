package com.kjh.musepicks.service;

import com.kjh.musepicks.dto.comment.CommentRequestDto;
import com.kjh.musepicks.dto.comment.CommentResponseDto;

import java.util.List;

public interface CommentService {
    void create_comment(CommentRequestDto commentRequestDto);
    void delete_comment(Long id);
    void update_comment(Long id, String content);
    List<CommentResponseDto> getAll();
}
