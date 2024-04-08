package com.example.practicespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordingStudioDto {
    private Long id;
    private String studioName;
    private String location;
    private int numberOfEmployees;
}