package com.example.practicespring.dto;

import com.example.practicespring.entity.Song;
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
public class ProducerDto {
    private Long id;
    private String name;
    private int workExperience;
    private String company;
    private Set<Song> songs = new HashSet<>();
}
