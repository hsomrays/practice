package com.example.practicespring.mapper;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.entity.Artist;

public class ArtistMapper {

    public static ArtistDto mapToArtistDto(Artist artist){
        return new ArtistDto(
                artist.getId(),
                artist.getName(),
                artist.getAge(),
                artist.getArtistName()
        );
    }

    public static Artist mapToArtist(ArtistDto artistDto){
        return new Artist(
                artistDto.getId(),
                artistDto.getName(),
                artistDto.getAge(),
                artistDto.getArtistName()
        );
    }
}