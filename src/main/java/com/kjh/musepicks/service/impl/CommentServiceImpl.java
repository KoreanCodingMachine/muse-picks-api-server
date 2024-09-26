package com.kjh.musepicks.service.impl;

import com.kjh.musepicks.domain.Comment;
import com.kjh.musepicks.dto.comment.CommentRequestDto;
import com.kjh.musepicks.dto.comment.CommentResponseDto;
import com.kjh.musepicks.repository.CommentRepository;
import com.kjh.musepicks.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public void create_comment(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment();
        comment.setContent(commentRequestDto.getContent());

        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void delete_comment(Long id) {
        commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update_comment(Long id, String content) {
        Comment foundComment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        foundComment.setContent(content);

        commentRepository.save(foundComment);
    }

    @Override
    public List<CommentResponseDto> getAll() {
        return commentRepository.findAllCommentsWithPost()
                .stream()
                .map(CommentResponseDto::of)
                .toList();
    }



    public List<CommentResponseDto> getAllComment() {
        return commentRepository.findAllCommentsWithAccount()
                .stream()
                .map(CommentResponseDto::of)
                .toList();
    }

    @Override
    public List<CommentResponseDto> getCommentByUserId(Long id) {

        List<Comment> comments = commentRepository.findByUserId(id);

        return comments.stream()
                .map(CommentResponseDto::of)
                .toList();

    }
}
