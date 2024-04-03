package com.example.practicespring.service;

import com.example.practicespring.entity.RecordingEngineer;
import com.example.practicespring.entity.RecordingStudio;

import java.util.List;

public interface RecordingEngineerService {
    RecordingEngineer createRecordingEngineer(RecordingEngineer recordingEngineer, RecordingStudio recordingStudio);
    RecordingEngineer getRecordingEngineerById(Long recordingEngineerId);
    List<RecordingEngineer> getAllRecordingEngineers();
    RecordingEngineer updateRecordingEngineer(Long recordingEngineerId, RecordingEngineer updatedRecordingEngineer);
    void deleteRecordingEngineer(Long recordingEngineerId);

}
