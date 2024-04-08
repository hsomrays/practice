package com.example.practicespring.service.impl;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.exception.ResourceNotFoundException;
import com.example.practicespring.repository.RecordingStudioRepository;
import com.example.practicespring.service.RecordingStudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RecordingStudioServiceImpl implements RecordingStudioService {
    private final RecordingStudioRepository recordingStudioRepository;

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

        return recordingStudioRepository.save(recordingStudio);
    }

    @Override
    public void deleteRecordingStudio(Long recordingStudioId) {
        recordingStudioRepository.deleteById(recordingStudioId);
    }

    @Override
    public List<Artist> getAllArtistsByRecordingStudioId(Long recordingStudioId) {
        RecordingStudio recordingStudio = recordingStudioRepository.findById(recordingStudioId)
                .orElseThrow(() -> new ResourceNotFoundException("RecordingStudio does not exist with the given id: " + recordingStudioId));

        // Возвращаем список артистов из студии звукозаписи в виде множества
        return recordingStudio.getArtists();
    }

}