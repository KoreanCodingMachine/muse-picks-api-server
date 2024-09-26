package com.kjh.musepicks.service.impl;

import com.kjh.musepicks.domain.Category;
import com.kjh.musepicks.domain.Post;
import com.kjh.musepicks.domain.PostCategory;
import com.kjh.musepicks.dto.post.PostRequestDto;
import com.kjh.musepicks.dto.post.PostResponseDto;
import com.kjh.musepicks.dto.postCategory.PostCategoryRequestDto;
import com.kjh.musepicks.repository.CategoryRepository;
import com.kjh.musepicks.repository.PostCategoryRepository;
import com.kjh.musepicks.repository.PostRepository;
import com.kjh.musepicks.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final PostCategoryRepository postCategoryRepository;

    @Override
    @Transactional
    public void insertPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setLocation(postRequestDto.getLocation());
        post.setPrice(postRequestDto.getPrice());
        post.setStart_dt(postRequestDto.getStartDt());
        post.setViews(postRequestDto.getViews());
        post.setPlaytime(postRequestDto.getPlayTime());
        post.setTotal_count(postRequestDto.getTotalCount());
        post.setReserved_count(postRequestDto.getReservedCount());
        post.setDescription(postRequestDto.getDescription());

        postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        postRepository.deleteById(id);
    }

    @Override
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAllPostsWithCategory()
                .stream()
                .map(PostResponseDto::of)
                .toList();
    }

    @Override
    @Transactional
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        return PostResponseDto.of(post);
    }

    @Override
    @Transactional
    public void updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        post.setTitle(postRequestDto.getTitle());
        post.setLocation(postRequestDto.getLocation());
        post.setPrice(postRequestDto.getPrice());
        post.setStart_dt(postRequestDto.getStartDt());
        post.setViews(postRequestDto.getViews());
        post.setPlaytime(postRequestDto.getPlayTime());
        post.setTotal_count(postRequestDto.getTotalCount());
        post.setReserved_count(postRequestDto.getReservedCount());
        post.setDescription(postRequestDto.getDescription());
    }

    @Override
    @Transactional
    public void addCategory(PostCategoryRequestDto postCategoryRequestDto) {
        Post post = postRepository.findById(postCategoryRequestDto.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        Category category = categoryRepository.findById(postCategoryRequestDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        PostCategory postCategory = new PostCategory();
        postCategory.setPost(post);
        postCategory.setCategory(category);

        postCategoryRepository.save(postCategory);
    }

}
