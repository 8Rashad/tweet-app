package com.example.applicationstarter.service;

import com.example.applicationstarter.dao.entity.CommentEntity;
import com.example.applicationstarter.dao.repository.CommentRepository;
import com.example.applicationstarter.exception.NotFoundException;
import com.example.applicationstarter.mapper.CommentMapper;
import com.example.applicationstarter.model.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.applicationstarter.model.dto.constant.ExceptionConstants.COMMENT_NOT_FOUND_CODE;
import static com.example.applicationstarter.model.dto.constant.ExceptionConstants.COMMENT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void changeCommentViewStatus(Long id) {
        var comment = fetchCommentIfExist(id);
        comment.setViewed(!comment.isViewed());
        commentRepository.save(comment);
    }

    public List<CommentDto> getCommentsByPost(Long postId) {
        var comments = commentRepository.findByPostId(postId);

        return comments.stream()
                .map(CommentMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public void changeCommentContent(Long id, String content) {
        var comment = fetchCommentIfExist(id);
        if (comment.isViewed()) comment.setViewed(false);
        comment.setContent(content);
        commentRepository.save(comment);
    }

    private CommentEntity fetchCommentIfExist(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format(COMMENT_NOT_FOUND_MESSAGE, id),
                                COMMENT_NOT_FOUND_CODE));
    }
}