package com.example.applicationstarter.controller;


import com.example.applicationstarter.model.dto.SaveTagDto;
import com.example.applicationstarter.model.dto.TagDto;
import com.example.applicationstarter.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/tweet/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveTag(@RequestBody SaveTagDto dto){
        tagService.saveTag(dto);
    }


    @GetMapping
    public List<TagDto> getTags() {
        return tagService.getTags();
    }
}
