package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.PostEntity;
import com.example.applicationstarter.model.dto.PostDto;


public class PostMapper {


    public static PostDto mapEntityToDto(PostEntity entity){

        return new PostDto(entity.getId(), entity.getTitle());
    }

}
