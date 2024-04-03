package com.example.practicespring.service;

import com.example.practicespring.entity.Album;
import com.example.practicespring.entity.Artist;

import java.util.List;

public interface AlbumService {
    Album createAlbum(Album album);
    Album getAlbumById(Long albumId);
    Album getAlbumByTitle(String title);
    List<Album> getAllAlbums();
    Album updateAlbum(Long albumId, Album updatedAlbum);
    void deleteAlbum(Long albumId);

}
