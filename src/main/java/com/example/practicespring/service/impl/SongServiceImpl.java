package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Song;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.SongRepository;
import com.example.practicespring.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song getSongById(Long songId) {
        return songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song does not exist with the given id: " + songId));
    }

    @Override
    public Song getSongByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title)
                .orElseThrow(() -> new ResourceNotFoundException("Song does not exist with the given id: " + title));
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song updateSong(Long songId, Song updatedSong) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song does not exist with the given id: " + songId));

        song.setTitle(updatedSong.getTitle());
        song.setDuration(updatedSong.getDuration());

        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Long songId) {
        songRepository.deleteById(songId);
    }
}