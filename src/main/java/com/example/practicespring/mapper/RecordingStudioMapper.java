package com.example.practicespring.mapper;

import com.example.practicespring.dto.RecordingStudioDto;
import com.example.practicespring.entity.RecordingStudio;

import java.util.ArrayList;
import java.util.List;

public class RecordingStudioMapper {

    public static RecordingStudioDto mapToRecordingStudioDto(RecordingStudio recordingStudio){
        return new RecordingStudioDto(
                recordingStudio.getId(),
                recordingStudio.getStudioName(),
                recordingStudio.getLocation(),
                recordingStudio.getNumberOfEmployees()
        );
    }

    public static List<RecordingStudioDto> mapToRecordingStudioDtoList(List<RecordingStudio> recordingStudios) {
        List<RecordingStudioDto> dtoList = new ArrayList<>();

        for (RecordingStudio recordingStudio : recordingStudios) {
            RecordingStudioDto dto = new RecordingStudioDto(
                    recordingStudio.getId(),
                    recordingStudio.getStudioName(),
                    recordingStudio.getLocation(),
                    recordingStudio.getNumberOfEmployees()
            );
            dtoList.add(dto);
        }

        return dtoList;
    }

/*    public static RecordingStudio mapToRecordingStudio(RecordingStudioDto recordingStudioDto){
        return new RecordingStudio(
                recordingStudioDto.getId(),
                recordingStudioDto.getStudioName(),
                recordingStudioDto.getLocation(),
                recordingStudioDto.getNumberOfEmployees()
        );
    }*/
}