package com.example.practicespring.service.impl;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.entity.Album;
import com.example.practicespring.mapper.AlbumMapper;
import com.example.practicespring.repository.AlbumRepository;
import com.example.practicespring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
