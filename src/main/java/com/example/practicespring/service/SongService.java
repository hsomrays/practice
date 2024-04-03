package com.example.practicespring.service;

import com.example.practicespring.entity.Song;
import com.example.practicespring.entity.Artist;

import java.util.List;

public interface SongService {
    Song createSong(Song song);
    Song getSongById(Long songId);
    Song getSongByTitle(String title);
    List<Song> getAllSongs();
    Song updateSong(Long songId, Song updatedSong);
    void deleteSong(Long songId);

}
