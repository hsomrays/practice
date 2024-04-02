package com.example.practicespring.service;

import com.example.practicespring.dto.AlbumDto;

import java.util.List;

public interface RecordingStudioService {
    AlbumDto createAlbum(AlbumDto albumDto);
    AlbumDto getAlbumById(Long albumId);
    List<AlbumDto> getAllAlbums();
    AlbumDto updateAlbum(Long albumId, AlbumDto updatedAlbum);
    void deleteAlbum(Long albumId);
}
