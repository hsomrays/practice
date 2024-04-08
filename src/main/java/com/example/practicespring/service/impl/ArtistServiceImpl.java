package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.ArtistRepository;
import com.example.practicespring.repository.RecordingStudioRepository;
import com.example.practicespring.service.ArtistService;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private RecordingStudioRepository recordingStudioRepository;


    @Override
    public Artist createArtist(Artist artist, Long recordingStudioId) {
        RecordingStudio recordingStudio = recordingStudioRepository.findById(recordingStudioId)
                .orElseThrow(() -> new NoSuchElementException("RecordingStudio not found with id: " + recordingStudioId));

        Artist savedArtist = artistRepository.save(artist);
        recordingStudio.getArtists().add(savedArtist);
        recordingStudioRepository.save(recordingStudio);
        savedArtist.getRecordingStudios().add(recordingStudio);
        return artistRepository.save(savedArtist);
    }

    @Override
    public Artist addRecordingStudio(Artist artist, Long recordingStudioId) {
        RecordingStudio recordingStudio = recordingStudioRepository.findById(recordingStudioId)
                .orElseThrow(() -> new NoSuchElementException("RecordingStudio not found with id: " + recordingStudioId));

        recordingStudio.getArtists().add(artist);
        recordingStudioRepository.save(recordingStudio);
        artist.getRecordingStudios().add(recordingStudio);
        return artistRepository.save(artist);
    }


    @Override
    public Artist getArtistById(Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given id: " + artistId));
    }

    @Override
    public Artist getArtistByArtistName(String artistName) {
        return artistRepository.findByArtistNameContainingIgnoreCase(artistName)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given name: " + artistName));
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist updateArtist(Long artistId, Artist updatedArtist) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist does not exist with the given id: " + artistId));

        artist.setName(updatedArtist.getName());
        artist.setArtistName(updatedArtist.getArtistName());
        artist.setAge(updatedArtist.getAge());
        artist.setRecordingStudios(updatedArtist.getRecordingStudios());

        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Long artistId) {
        Artist artist = this.getArtistById(artistId);
        Set<RecordingStudio> recordingStudios = artist.getRecordingStudios();
        for(RecordingStudio recordingStudio : recordingStudios){
            recordingStudio.getArtists().remove(artist);
            artist.getRecordingStudios().remove(recordingStudio);
        }
        artistRepository.deleteById(artistId);
    }
}