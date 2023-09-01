package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.CommentEntity;
import com.example.applicationstarter.dao.entity.PostEntity;

public class CommentFactory {
    public static CommentEntity buildCommentEntity(PostEntity post, String content) {
        return CommentEntity.builder()
                .post(post)
                .content(content)
                .build();
    }
}