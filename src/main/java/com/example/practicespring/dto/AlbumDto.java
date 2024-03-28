package com.example.practicespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private String genre;
    private Long artistId;
}
