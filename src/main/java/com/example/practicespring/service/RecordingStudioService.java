package com.example.practicespring.service;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;

import java.util.List;
import java.util.Set;

public interface RecordingStudioService {
    RecordingStudio createRecordingStudio(RecordingStudio recordingStudio);
    RecordingStudio getRecordingStudioById(Long recordingStudioId);
    //RecordingStudio getRecordingStudioByStudioName(String studioName);
    List<RecordingStudio> getAllRecordingStudios();
    RecordingStudio updateRecordingStudio(Long recordingStudioId, RecordingStudio updatedRecordingStudio);
    void deleteRecordingStudio(Long recordingStudioId);
    List<Artist> getAllArtistsByRecordingStudioId(Long recordingStudioId);
}
