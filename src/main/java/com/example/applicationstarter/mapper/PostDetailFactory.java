package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.PostDetailEntity;
import com.example.applicationstarter.dao.entity.PostEntity;

public class PostDetailFactory {

    public static PostDetailEntity buildPostDetailEntity(PostEntity post, String createdBy){
        return PostDetailEntity.builder()
                .post(post)
                .createdBy(createdBy)
                .build();
    }
}
