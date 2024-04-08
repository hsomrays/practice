package com.example.practicespring.service;

import com.example.practicespring.entity.Album;

import java.util.List;

public interface AlbumService {
    Album createAlbum(Album album);
    Album getAlbumById(Long albumId);
    List<Album> getAllAlbums();
    Album updateAlbum(Long albumId, Album updatedAlbum);
    void deleteAlbum(Long albumId);

}
