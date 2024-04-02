package com.example.practicespring.dto;

import com.example.practicespring.entity.Album;
import com.example.practicespring.entity.Producer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {
    private Long id;
    private String title;
    private Album album;
    private Time duration;
    private Set<Producer> producers;
}
