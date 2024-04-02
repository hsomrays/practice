package com.example.practicespring.dto;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.Song;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long id;
    private String title;
    private Date releaseDate;
    private String genre;
    @JsonIgnore
    private Artist artist;
    private Set<Song> songs;
}
