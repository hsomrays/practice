package com.example.practicespring.controllers;

import com.example.practicespring.dto.AlbumDto;
import com.example.practicespring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private AlbumService albumService;

    //Build Add Album REST API
    @PostMapping
    public ResponseEntity<AlbumDto> createAlbum(@RequestBody AlbumDto albumDto){
        AlbumDto savedAlbum = albumService.createAlbum(albumDto);
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }
}
