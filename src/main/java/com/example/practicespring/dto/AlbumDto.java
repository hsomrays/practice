package com.example.practicespring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long id;
    private String title;
    private Date releaseDate;
    private String genre;
    private Long artistId;
}
