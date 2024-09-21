package com.kjh.musepicks.service.impl;

import com.kjh.musepicks.domain.Comment;
import com.kjh.musepicks.dto.comment.CommentRequestDto;
import com.kjh.musepicks.dto.comment.CommentResponseDto;
import com.kjh.musepicks.repository.CommentRepository;
import com.kjh.musepicks.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void create_comment(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment();

        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.toString();
        comment.setCreated_dt(date);
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

        LocalDateTime localDateTime = LocalDateTime.now();
        foundComment.setCreated_dt(localDateTime.toString());

        commentRepository.save(foundComment);
    }

    @Override
    public List<CommentResponseDto> getAll() {
        return commentRepository.findAll()
                .stream()
                .map(CommentResponseDto::of)
                .toList();
    }
}
