package com.example.practicespring.mapper;

import com.example.practicespring.dto.ArtistDto;
import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArtistMapper {

    public static ArtistDto mapToArtistDto(Artist artist){

        Set<RecordingStudio> recordingStudios = artist.getRecordingStudios();
        List<String> allStudiosList = new ArrayList<>();

        for (RecordingStudio recordingStudio : recordingStudios){
            allStudiosList.add(recordingStudio.getStudioName());
        }

        return new ArtistDto(
                artist.getId(),
                artist.getName(),
                artist.getAge(),
                artist.getArtistName(),
                allStudiosList
        );
    }

    public static List<ArtistDto> mapToArtistDtoList(List<Artist> artists) {
        List<ArtistDto> dtoList = new ArrayList<>();

        for (Artist artist : artists) {

            Set<RecordingStudio> recordingStudios = artist.getRecordingStudios();
            List<String> allStudiosList = new ArrayList<>();

            for (RecordingStudio recordingStudio : recordingStudios){
                allStudiosList.add(recordingStudio.getStudioName());
            }
            ArtistDto dto = new ArtistDto(
                    artist.getId(),
                    artist.getName(),
                    artist.getAge(),
                    artist.getArtistName(),
                    allStudiosList
            );
            dtoList.add(dto);
        }

        return dtoList;
    }

}