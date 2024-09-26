package com.kjh.musepicks.controller;

import com.kjh.musepicks.dto.ApiResponse;
import com.kjh.musepicks.dto.ApiResponseCode;
import com.kjh.musepicks.dto.post.PostRequestDto;
import com.kjh.musepicks.dto.post.PostResponseDto;
import com.kjh.musepicks.dto.postCategory.PostCategoryRequestDto;
import com.kjh.musepicks.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @Operation(summary = "게시글 생성", description = "게시글 정보를 생성한다.")
    @PostMapping("/posts")
    public ApiResponse postMember(@RequestBody @Valid PostRequestDto postRequestDto) {
        postService.insertPost(postRequestDto);
        return ApiResponse.of(ApiResponseCode.POST_CREATED_OK);
    }

    @Operation(summary = "게시글 삭제", description = "게시글 정보 단건을 삭제한다.")
    @DeleteMapping("/posts/{id}")
    public ApiResponse deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ApiResponse.of(ApiResponseCode.POST_DELETED_OK);
    }

    @Operation(summary = "게시글 조회", description = "모든 게시글를 조회한다.")
    @GetMapping("/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @Operation(summary = "게시글 단건 조회", description = "id를 받아서 게시글을 단건 조회한다.")
    @GetMapping("/posts/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @Operation(summary = "게시글 수정", description = "id를 받아서 게시글을 단건 수정한다.")
    @PutMapping("/posts/{id}")
    public ApiResponse updatePost(@RequestBody @Valid PostRequestDto postRequestDto, @PathVariable Long id) {
        postService.updatePost(id, postRequestDto);
        return ApiResponse.of(ApiResponseCode.POST_UPDATED_OK);
    }

    @Operation(summary = "게시글 카테고리 추가", description = "게시글 id, 카테고리 id")
    @PostMapping("/posts/category")
    public ApiResponse addCategory(@RequestBody PostCategoryRequestDto postCategoryRequestDto) {
        postService.addCategory(postCategoryRequestDto);
        return ApiResponse.of(ApiResponseCode.POST_CATEGORY_CREATED_OK);
    }

}
