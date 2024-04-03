package com.example.practicespring.controllers;

import com.example.practicespring.entity.Album;
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
    public ResponseEntity<Album> createAlbum(@RequestBody Album album){
        Album savedAlbum = albumService.createAlbum(album);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    // Build Get Album REST API
    @GetMapping("find/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") Long albumId){
        Album album = albumService.getAlbumById(albumId);
        return ResponseEntity.ok(album);
    }

    // Build Get All Albums REST API
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(){
        List<Album> albums = albumService.getAllAlbums();
        return ResponseEntity.ok(albums);
    }

    // Build Update Album REST API

    @PutMapping("update/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("id") Long albumId,
                                                @RequestBody Album updatedAlbum){
        Album checkAlbum = albumService.updateAlbum(albumId, updatedAlbum);
        return ResponseEntity.ok(checkAlbum);
    }

    // Build Delete Album REST API
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable("id") Long albumId){
        albumService.deleteAlbum(albumId);
        return ResponseEntity.ok("Album deleted successfully.");
    }
}
