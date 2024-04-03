package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.ArtistRepository;
import com.example.practicespring.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given id: " + artistId));
    }

    @Override
    public Artist getArtistByArtistName(String artistName) {
        return artistRepository.findByArtistNameContainingIgnoreCase(artistName)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given name: " + artistName));
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist updateArtist(Long artistId, Artist updatedArtist) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given id: " + artistId));

        artist.setName(updatedArtist.getName());
        artist.setArtistName(updatedArtist.getArtistName());
        artist.setAge(updatedArtist.getAge());
        artist.setRecordingStudios(updatedArtist.getRecordingStudios());

        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }
}