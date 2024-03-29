package com.example.practicespring.controllers;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private AlbumService albumService;

    // Build Add Album REST API
    @PostMapping
    public ResponseEntity<AlbumDto> createAlbum(@RequestBody AlbumDto albumDto){
        AlbumDto savedAlbum = albumService.createAlbum(albumDto);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    // Build Get Album REST API
    @GetMapping("{id}")
    public ResponseEntity<AlbumDto> getAlbumById(@PathVariable("id") Long albumId){
        AlbumDto albumDto = albumService.getAlbumById(albumId);
        return ResponseEntity.ok(albumDto);
    }

    // Build Get All Albums REST API
    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAllAlbums(){
        List<AlbumDto> albums = albumService.getAllAlbums();
        return ResponseEntity.ok(albums);
    }

    // Build Update Album REST API
    @PutMapping("{id}")
    public ResponseEntity<AlbumDto> updateAlbum(@PathVariable("id") Long albumId,
                                                @RequestBody AlbumDto updatedAlbum){
        AlbumDto albumDto = albumService.updateAlbum(albumId, updatedAlbum);
        return ResponseEntity.ok(albumDto);
    }

    // Build Delete Album REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable("id") Long albumId){
        albumService.deleteAlbum(albumId);
        return ResponseEntity.ok("Album deleted successfully.");
    }
}
