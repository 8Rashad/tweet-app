package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.CommentEntity;
import com.example.applicationstarter.model.dto.CommentDto;

public class CommentMapper {
    public static CommentDto mapEntityToDto(CommentEntity entity) {
        return CommentDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .viewed(entity.isViewed())
                .build();
    }
}
