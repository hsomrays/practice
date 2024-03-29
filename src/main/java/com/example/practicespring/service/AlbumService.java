package com.example.practicespring.service;

import com.example.practicespring.dto.AlbumDto;

public interface AlbumService {
    AlbumDto createAlbum(AlbumDto albumDto);
    AlbumDto getAlbumById(Long albumId);
}
