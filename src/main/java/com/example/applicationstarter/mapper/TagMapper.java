package com.example.applicationstarter.mapper;

import com.example.applicationstarter.dao.entity.TagEntity;
import com.example.applicationstarter.model.dto.SaveTagDto;
import com.example.applicationstarter.model.dto.TagDto;

public class TagMapper {
    public static TagEntity mapSaveTagRequestToEntity(SaveTagDto dto) {
        return TagEntity.builder()
                .name(dto.getName())
                .build();
    }

    public static TagDto mapEntityToDto(TagEntity entity) {
        return TagDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }
}
