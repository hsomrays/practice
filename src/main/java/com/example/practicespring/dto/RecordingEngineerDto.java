package com.example.practicespring.dto;

import com.example.practicespring.entity.RecordingStudio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordingEngineerDto {
    private Long id;
    private String name;
    private int workExperience;
    private int rating;
    private RecordingStudio recordingStudio;
}
