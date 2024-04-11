package com.example.practicespring.service.impl;

import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.ArtistRepository;
import com.example.practicespring.repository.RecordingStudioRepository;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecordingStudioServiceImpl implements RecordingStudioService {
    private final RecordingStudioRepository recordingStudioRepository;
    private final ArtistRepository artistRepository;
    @Override
    public RecordingStudio createRecordingStudio(RecordingStudio recordingStudio) {
        return recordingStudioRepository.save(recordingStudio);
    }

    @Override
    public RecordingStudio getRecordingStudioById(Long recordingStudioId) {
        return recordingStudioRepository.findById(recordingStudioId)
                .orElseThrow(() -> new ResourceNotFoundException("RecordingStudio does not exist with the given id: " + recordingStudioId));
    }

    @Override
    public List<RecordingStudio> getAllRecordingStudios() {
        return recordingStudioRepository.findAll();
    }

    @Override
    public RecordingStudio updateRecordingStudio(Long recordingStudioId, RecordingStudio updatedRecordingStudio) {
        RecordingStudio recordingStudio = recordingStudioRepository.findById(recordingStudioId)
                .orElseThrow(() -> new ResourceNotFoundException("RecordingStudio does not exist with the given id: " + recordingStudioId));

        recordingStudio.setStudioName(updatedRecordingStudio.getStudioName());
        recordingStudio.setLocation(updatedRecordingStudio.getLocation());
        recordingStudio.setNumberOfEmployees(updatedRecordingStudio.getNumberOfEmployees());
        recordingStudio.setArtists(updatedRecordingStudio.getArtists());

        return recordingStudioRepository.save(recordingStudio);
    }

    @Override
    public void deleteRecordingStudio(Long recordingStudioId) {
        recordingStudioRepository.deleteById(recordingStudioId);
    }

}