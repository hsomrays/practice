package com.example.practicespring.service.impl;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.entity.Artist;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.mapper.ArtistMapper;
import com.example.practicespring.repository.ArtistRepository;
import com.example.practicespring.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private ArtistRepository artistRepository;

    @Override
    public ArtistDto createArtist(ArtistDto artistDto) {
        Artist artist = ArtistMapper.mapToArtist(artistDto);
        Artist savedArtist = artistRepository.save(artist);
        return ArtistMapper.mapToArtistDto(savedArtist);
    }

    @Override
    public ArtistDto getArtistById(Long artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Artist is not exists with the given id:" + artistId));
        return ArtistMapper.mapToArtistDto(artist);
    }

    @Override
    public List<ArtistDto> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream().map((artist -> ArtistMapper.mapToArtistDto(artist)))
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDto updateArtist(Long artistId, ArtistDto updatedArtist) {

        Artist artist = artistRepository.findById(artistId).orElseThrow(
                () -> new ResourceNotFoundException("Artist is not exist with given id: " + artistId)
        );

        artist.setName(updatedArtist.getName());
        artist.setAge(updatedArtist.getAge());
        artist.setArtistName(updatedArtist.getArtistName());

        artistRepository.save(artist);
        Artist updatedArtistObj = artistRepository.save(artist);
        return ArtistMapper.mapToArtistDto(updatedArtistObj);
    }

    @Override
    public void deleteArtist(Long artistId) {

        Artist artist = artistRepository.findById(artistId).orElseThrow(
                () -> new ResourceNotFoundException("Artist is not exist with given id: " + artistId)
        );

        artistRepository.deleteById(artistId);
    }
}
