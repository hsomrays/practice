package com.example.practicespring.service;

import com.example.practicespring.dto.ArtistDto;

import java.util.List;

public interface ArtistService {
    ArtistDto createArtist(ArtistDto artistDto);
    ArtistDto getArtistById(Long artistId);
    List<ArtistDto> getAllArtists();
    ArtistDto updateArtist(Long artistId, ArtistDto updatedArtist);
    void deleteArtist(Long artistId);

}
