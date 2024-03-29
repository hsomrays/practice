package com.example.practicespring.service.impl;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.entity.Album;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.mapper.AlbumMapper;
import com.example.practicespring.repository.AlbumRepository;
import com.example.practicespring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private AlbumRepository albumRepository;

    @Override
    public AlbumDto createAlbum(AlbumDto albumDto) {
        Album album = AlbumMapper.mapToAlbum(albumDto);
        Album savedAlbum = albumRepository.save(album);
        return AlbumMapper.mapToAlbumDto(savedAlbum);
    }

    @Override
    public AlbumDto getAlbumById(Long albumId) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Album is not exists with the given id:" + albumId));
        return AlbumMapper.mapToAlbumDto(album);
    }

    @Override
    public List<AlbumDto> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map((album -> AlbumMapper.mapToAlbumDto(album)))
                .collect(Collectors.toList());
    }

    @Override
    public AlbumDto updateAlbum(Long albumId, AlbumDto updatedAlbum) {

        Album album = albumRepository.findById(albumId).orElseThrow(
                () -> new ResourceNotFoundException("Album is not exist with given id: " + albumId)
        );

        album.setTitle(updatedAlbum.getTitle());
        album.setReleaseDate(updatedAlbum.getReleaseDate());
        album.setGenre(updatedAlbum.getGenre());
        album.setArtistId(updatedAlbum.getArtistId());

        albumRepository.save(album);
        Album updatedAlbumObj = albumRepository.save(album);
        return AlbumMapper.mapToAlbumDto(updatedAlbumObj);
    }

    @Override
    public void deleteAlbum(Long albumId) {

        Album album = albumRepository.findById(albumId).orElseThrow(
                () -> new ResourceNotFoundException("Album is not exist with given id: " + albumId)
        );

        albumRepository.deleteById(albumId);
    }
}
