package com.example.practicespring.controllers;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.dto.RecordingStudioDto;
import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.mapper.ArtistMapper;
import com.example.practicespring.mapper.RecordingStudioMapper;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/recordingStudios")

public class RecordingStudioController {


    private RecordingStudioService recordingStudioService;
    //private SessionFactory sessionFactory;


    @PostMapping
    public ResponseEntity<RecordingStudio> createRecordingStudio(@RequestBody RecordingStudio recordingStudio){
        RecordingStudio savedRecordingStudio = recordingStudioService.createRecordingStudio(recordingStudio);
        return new ResponseEntity<>(savedRecordingStudio, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RecordingStudioDto> getRecordingStudioById(@PathVariable("id") Long recordingStudioId){
        RecordingStudio recordingStudio = recordingStudioService.getRecordingStudioById(recordingStudioId);
        RecordingStudioDto recordingStudioDto = RecordingStudioMapper.mapToRecordingStudioDto(recordingStudio);
        return ResponseEntity.ok(recordingStudioDto);
    }

    @GetMapping("{id}/artists")
    public ResponseEntity<List<ArtistDto>> getAllRecordingStudioArtists(@PathVariable("id") Long recordingStudioId){
        RecordingStudio recordingStudio = recordingStudioService.getRecordingStudioById(recordingStudioId);
        List<ArtistDto> artistDtoList = ArtistMapper.mapToArtistDtoList(recordingStudio.getArtists());
        return ResponseEntity.ok(artistDtoList);
    }


    @GetMapping()
    public ResponseEntity<List<RecordingStudioDto>> getAllRecordingStudios(){
        List<RecordingStudio> recordingStudios = recordingStudioService.getAllRecordingStudios();
        List<RecordingStudioDto> recordingStudiosDto = RecordingStudioMapper.mapToRecordingStudioDtoList(recordingStudios);
        return ResponseEntity.ok(recordingStudiosDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<RecordingStudio> updateRecordingStudio(@PathVariable("id") Long recordingStudioId,
                                             @RequestBody RecordingStudio updatedRecordingStudio){
        RecordingStudio checkRecordingStudio = recordingStudioService.updateRecordingStudio(recordingStudioId, updatedRecordingStudio);
        return ResponseEntity.ok(checkRecordingStudio);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordingStudio(@PathVariable("id") Long recordingStudioId){
        recordingStudioService.deleteRecordingStudio(recordingStudioId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
