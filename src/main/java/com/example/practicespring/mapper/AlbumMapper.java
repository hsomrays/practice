package com.example.practicespring.mapper;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.entity.Album;

public class AlbumMapper {

    public static AlbumDto mapToAlbumDto(Album album){
        return new AlbumDto(
                album.getId(),
                album.getTitle(),
                album.getReleaseDate(),
                album.getGenre(),
                album.getArtist(),
                album.getSongs()
        );
    }

    public static Album mapToAlbum(AlbumDto albumDto){
        return new Album(
                albumDto.getId(),
                albumDto.getTitle(),
                albumDto.getReleaseDate(),
                albumDto.getGenre(),
                albumDto.getArtist(),
                albumDto.getSongs()
        );
    }
}
