package com.example.practicespring.controllers;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private ArtistService artistService;

    // Build Add Artist REST API
    @PostMapping
    public ResponseEntity<ArtistDto> createArtist(@RequestBody ArtistDto artistDto){
        ArtistDto savedArtist = artistService.createArtist(artistDto);
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }

    // Build Get Artist REST API
    @GetMapping("find/{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable("id") Long artistId){
        ArtistDto artistDto = artistService.getArtistById(artistId);
        return ResponseEntity.ok(artistDto);
    }

    // Build Get All Artists REST API
    @GetMapping
    public ResponseEntity<List<ArtistDto>> getAllArtists(){
        List<ArtistDto> artists = artistService.getAllArtists();
        return ResponseEntity.ok(artists);
    }

    // Build Update Artist REST API
    @PutMapping("update/{id}")
    public ResponseEntity<ArtistDto> updateArtist(@PathVariable("id") Long artistId,
                                                @RequestBody ArtistDto updatedArtist){
        ArtistDto artistDto = artistService.updateArtist(artistId, updatedArtist);
        return ResponseEntity.ok(artistDto);
    }

    // Build Delete Artist REST API
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable("id") Long artistId){
        artistService.deleteArtist(artistId);
        return ResponseEntity.ok("Artist deleted successfully.");
    }
}
