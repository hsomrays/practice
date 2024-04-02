package com.example.practicespring.dto;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingEngineer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordingStudioDto {
    private Long id;
    private String studioName;
    private String location;
    private int numberOfEmployees;
    private Set<Artist> artists = new HashSet<>();
    private Set<RecordingEngineer> recordingEngineers;
}
