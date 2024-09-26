package com.kjh.musepicks.service;

import com.kjh.musepicks.domain.Post;
import com.kjh.musepicks.dto.post.PostRequestDto;
import com.kjh.musepicks.dto.post.PostResponseDto;
import com.kjh.musepicks.dto.postCategory.PostCategoryRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {
    void insertPost(PostRequestDto postRequestDto); // 게시글 등록
    void deletePost(Long id); // 게시글 삭제
    List<PostResponseDto> getAllPosts();          // 게시글 전체 조회
    PostResponseDto getPostById(Long id);        // 멤버 단건 조회
    void updatePost(Long id, PostRequestDto postRequestDto);   // 포스트 수정
    void addCategory(PostCategoryRequestDto postCategoryRequestDto); // 특정 포스트에 카테고리 추가
}
