package com.example.practicespring.service;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.entity.Album;

import java.util.List;

public interface AlbumService {
    AlbumDto createAlbum(AlbumDto albumDto);
    AlbumDto getAlbumById(Long albumId);
    List<AlbumDto> getAllAlbums();
    Album updateAlbum(Long albumId, Album updatedAlbum);
    void deleteAlbum(Long albumId);

}
