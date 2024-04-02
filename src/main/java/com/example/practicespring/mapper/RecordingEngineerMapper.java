package com.example.practicespring.mapper;

import com.example.practicespring.dto.RecordingEngineerDto;
import com.example.practicespring.entity.RecordingEngineer;

public class RecordingEngineerMapper {

    public static RecordingEngineerDto mapToRecordingEngineerDto(RecordingEngineer recordingEngineer){
        return new RecordingEngineerDto(
                recordingEngineer.getId(),
                recordingEngineer.getName(),
                recordingEngineer.getWorkExperience(),
                recordingEngineer.getRating(),
                recordingEngineer.getRecordingStudio()
        );
    }

    public static RecordingEngineer mapToRecordingEngineer(RecordingEngineerDto recordingEngineerDto){
        return new RecordingEngineer(
                recordingEngineerDto.getId(),
                recordingEngineerDto.getName(),
                recordingEngineerDto.getWorkExperience(),
                recordingEngineerDto.getRating(),
                recordingEngineerDto.getRecordingStudio()
        );
    }
}
