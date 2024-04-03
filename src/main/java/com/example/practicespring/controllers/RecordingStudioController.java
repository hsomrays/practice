package com.example.practicespring.controllers;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.service.ArtistService;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/recordingStudios")
public class RecordingStudioController {
    private RecordingStudioService recordingStudioService;
    private ArtistService artistService;

    @PostMapping
    public ResponseEntity<RecordingStudio> createRecordingStudio(@RequestBody RecordingStudio recordingStudio){
        RecordingStudio savedRecordingStudio = recordingStudioService.createRecordingStudio(recordingStudio);
        return new ResponseEntity<>(savedRecordingStudio, HttpStatus.CREATED);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<RecordingStudio> getRecordingStudioById(@PathVariable("id") Long recordingStudioId){
        RecordingStudio recordingStudio = recordingStudioService.getRecordingStudioById(recordingStudioId);
        return ResponseEntity.ok(recordingStudio);
    }

    @GetMapping("findByName/{studioName}")
    public ResponseEntity<RecordingStudio> getRecordingStudioByName(@PathVariable("studioName") String studioName){
        RecordingStudio recordingStudio = recordingStudioService.getRecordingStudioByStudioName(studioName);
        return ResponseEntity.ok(recordingStudio);
    }

    @GetMapping
    public ResponseEntity<List<RecordingStudio>> getAllRecordingStudios(){
        List<RecordingStudio> recordingStudios = recordingStudioService.getAllRecordingStudios();
        return ResponseEntity.ok(recordingStudios);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RecordingStudio> updateRecordingStudio(@PathVariable("id") Long recordingStudioId,
                                             @RequestBody RecordingStudio updatedRecordingStudio){
        RecordingStudio checkRecordingStudio = recordingStudioService.updateRecordingStudio(recordingStudioId, updatedRecordingStudio);
        return ResponseEntity.ok(checkRecordingStudio);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRecordingStudio(@PathVariable("id") Long recordingStudioId){
        recordingStudioService.deleteRecordingStudio(recordingStudioId);
        return ResponseEntity.ok("RecordingStudio deleted successfully.");
    }
}
