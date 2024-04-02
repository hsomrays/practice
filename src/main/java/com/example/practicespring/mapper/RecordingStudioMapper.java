package com.example.practicespring.mapper;

import com.example.practicespring.dto.RecordingStudioDto;
import com.example.practicespring.entity.RecordingStudio;

public class RecordingStudioMapper {

    public static RecordingStudioDto mapToRecordingStudioDto(RecordingStudio recordingStudio){
        return new RecordingStudioDto(
                recordingStudio.getId(),
                recordingStudio.getStudioName(),
                recordingStudio.getLocation(),
                recordingStudio.getNumberOfEmployees(),
                recordingStudio.getArtists(),
                recordingStudio.getRecordingEngineers()
        );
    }

    public static RecordingStudio mapToRecordingStudio(RecordingStudioDto recordingStudioDto){
        return new RecordingStudio(
                recordingStudioDto.getId(),
                recordingStudioDto.getStudioName(),
                recordingStudioDto.getLocation(),
                recordingStudioDto.getNumberOfEmployees(),
                recordingStudioDto.getArtists(),
                recordingStudioDto.getRecordingEngineers()
        );
    }
}
