package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.PostEntity;
import com.example.applicationstarter.model.dto.SavePostDto;

public class PostFactory {
    public static PostEntity buildPostEntity(SavePostDto dto) {
        return PostEntity.builder()
                .title(dto.getTitle())
                .build();
    }
}