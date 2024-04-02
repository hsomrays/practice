package com.example.practicespring.dto;

import com.example.practicespring.entity.Album;
import com.example.practicespring.entity.RecordingStudio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private Long id;
    private String name;
    private int age;
    private Set<RecordingStudio> recordingStudios;
    private String artistName;
    private Set<Album> albums;
}
