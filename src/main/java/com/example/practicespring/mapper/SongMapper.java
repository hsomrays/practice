package com.example.practicespring.mapper;

import com.example.practicespring.dto.SongDto;
import com.example.practicespring.entity.Song;

public class SongMapper {

    public static SongDto mapToSongDto(Song song){
        return new SongDto(
                song.getId(),
                song.getTitle(),
                song.getAlbum(),
                song.getDuration(),
                song.getProducers()
        );
    }

    public static Song mapToSong(SongDto songDto){
        return new Song(
                songDto.getId(),
                songDto.getTitle(),
                songDto.getAlbum(),
                songDto.getDuration(),
                songDto.getProducers()
        );
    }
}
