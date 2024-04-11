package com.example.practicespring.controllers;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.entity.Artist;
import com.example.practicespring.mapper.ArtistMapper;
import com.example.practicespring.repository.ArtistRepository;
import com.example.practicespring.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artists")

public class ArtistController {

    private ArtistService artistService;
    private ArtistRepository artistRepository;

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist savedArtist = new Artist();
        Optional<Artist> existingArtist = artistRepository.findFirstByNameAndAgeAndArtistName(artist.getName(), artist.getAge(), artist.getArtistName());
        if (existingArtist.isPresent()) {
            return new ResponseEntity<>(artist, HttpStatus.CONFLICT);
        } else {
            savedArtist = artistService.createArtist(artist);
        }
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") Long artistId){
        Artist artist = artistService.getArtistById(artistId);
        return ResponseEntity.ok(artist);
    }

    @GetMapping("findByName/{artistName}")
    public ResponseEntity<ArtistDto> getArtistByName(@PathVariable("artistName") String artistName){
        Artist artist = artistService.getArtistByArtistName(artistName);
        ArtistDto artistDto = ArtistMapper.mapToArtistDto(artist);
        return ResponseEntity.ok(artistDto);
    }

    @GetMapping()
    public ResponseEntity<List<Artist>> getAllArtists(){
        List<Artist> artists = artistService.getAllArtists();
        return ResponseEntity.ok(artists);
    }

    @PutMapping("{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable("id") Long artistId,
                                               @RequestBody Artist updatedArtist){
        Artist checkArtist = artistService.updateArtist(artistId, updatedArtist);
        return ResponseEntity.ok(checkArtist);
    }

    @DeleteMapping("{artistId}")
    public ResponseEntity<?> deleteArtist(@PathVariable Long artistId) {
        artistService.deleteArtist(artistId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    }
