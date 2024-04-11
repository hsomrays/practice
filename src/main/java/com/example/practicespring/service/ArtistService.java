package com.example.practicespring.service;

import com.example.practicespring.entity.Artist;

import java.util.List;

public interface ArtistService {
    Artist createArtist(Artist artist);
    Artist getArtistById(Long artistId);
    Artist getArtistByArtistName(String artistName);
    List<Artist> getAllArtists();
    Artist updateArtist(Long artistId, Artist updatedArtist);
    void deleteArtist(Long artistId);

}
