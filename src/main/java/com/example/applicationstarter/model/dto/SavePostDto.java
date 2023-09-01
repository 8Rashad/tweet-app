package com.example.applicationstarter.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavePostDto {
    private String title;
    private String createdBy;
    private Set<Long> tagIds;
}
