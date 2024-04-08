package com.example.practicespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private Long id;
    private String name;
    private int age;
    private String artistName;
    private List<String> allStudios;
}