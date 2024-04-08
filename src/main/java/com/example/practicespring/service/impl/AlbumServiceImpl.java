package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Album;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.AlbumRepository;
import com.example.practicespring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    @Override
    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album getAlbumById(Long albumId) {
        return albumRepository.findById(albumId)
                .orElseThrow(() -> new ResourceNotFoundException("Album does not exist with the given id: " + albumId));
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album updateAlbum(Long albumId, Album updatedAlbum) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResourceNotFoundException("Album does not exist with the given id: " + albumId));

        album.setTitle(updatedAlbum.getTitle());
        album.setGenre(updatedAlbum.getGenre());
        album.setReleaseDate(updatedAlbum.getReleaseDate());

        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}