package com.example.practicespring.controllers;

import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
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

    @PostMapping
    public ResponseEntity<RecordingStudio> createRecordingStudio(@RequestBody RecordingStudio recordingStudio){
        RecordingStudio savedRecordingStudio = recordingStudioService.createRecordingStudio(recordingStudio);
        return new ResponseEntity<>(savedRecordingStudio, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RecordingStudio> getRecordingStudioById(@PathVariable("id") Long recordingStudioId){
        RecordingStudio recordingStudio = recordingStudioService.getRecordingStudioById(recordingStudioId);
        return ResponseEntity.ok(recordingStudio);
    }

    @GetMapping()
    public ResponseEntity<List<RecordingStudio>> getAllRecordingStudios(){
        List<RecordingStudio> recordingStudios = recordingStudioService.getAllRecordingStudios();
        return ResponseEntity.ok(recordingStudios);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecordingStudio(@PathVariable("id") Long recordingStudioId){
        recordingStudioService.deleteRecordingStudio(recordingStudioId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("{id}")
    public ResponseEntity<RecordingStudio> updateRecordingStudio(@PathVariable("id") Long recordingStudioId,
                                                                 @RequestBody RecordingStudio updatedRecordingStudio){

        RecordingStudio checkRecordingStudio = recordingStudioService.updateRecordingStudio(recordingStudioId, updatedRecordingStudio);
        return ResponseEntity.ok(checkRecordingStudio);
    }
}