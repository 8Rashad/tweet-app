package com.example.applicationstarter.service;

import com.example.applicationstarter.dao.entity.TagEntity;
import com.example.applicationstarter.dao.repository.TagRepository;
import com.example.applicationstarter.mapper.TagMapper;
import com.example.applicationstarter.model.dto.SaveTagDto;
import com.example.applicationstarter.model.dto.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.applicationstarter.mapper.TagMapper.mapSaveTagRequestToEntity;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public void saveTag(SaveTagDto request) {
        tagRepository.save(mapSaveTagRequestToEntity(request));
    }

    public List<TagEntity> getTagsByIds(Set<Long> ids) {
        return tagRepository.findByIdIn(ids);
    }

    public List<TagDto> getTags() {
        return tagRepository.findAll().stream()
                .map(TagMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
