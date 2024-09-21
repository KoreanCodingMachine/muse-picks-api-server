package com.kjh.musepicks.controller;

import com.kjh.musepicks.dto.ApiResponse;
import com.kjh.musepicks.dto.ApiResponseCode;
import com.kjh.musepicks.dto.account.AccountRequestDto;
import com.kjh.musepicks.dto.account.AccountResponseDto;
import com.kjh.musepicks.dto.account.AccountUpdateRequestDto;
import com.kjh.musepicks.dto.comment.CommentRequestDto;
import com.kjh.musepicks.dto.comment.CommentResponseDto;
import com.kjh.musepicks.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Operation(summary = "댓글 생성", description = "새로운 댓글을 생성한다.")
    @PostMapping("/api/comments")
    public ApiResponse postComment(@RequestBody @Valid CommentRequestDto commentRequestDto) {

        commentService.create_comment(commentRequestDto);

        return ApiResponse.of(ApiResponseCode.COMMENT_CREATED_OK);
    }

    @Operation(summary = "댓글 삭제", description = "댓글 단건을 삭제한다.")
    @DeleteMapping("/api/comments/{id}")
    public ApiResponse deleteComment(@PathVariable Long id) {
        commentService.delete_comment(id);
        return ApiResponse.of(ApiResponseCode.COMMENT_DELETED_OK);
    }

    @Operation(summary = "모든 댓글 조회", description = "모든 댓글을 조회한다.")
    @GetMapping("/api/comments")
    public List<CommentResponseDto> getAllComment() {
        return commentService.getAll();
    }

    @Operation(summary = "댓글 수정", description = "댓글 id를 받아서 수정한다.")
    @PutMapping("/api/comments/{id}")
    public ApiResponse updateComment(@RequestBody @Valid CommentRequestDto commentRequestDto, @PathVariable Long id) {
        commentService.update_comment(id, commentRequestDto.getContent());
        return ApiResponse.of(ApiResponseCode.COMMENT_UPDATED_OK);
    }

}
