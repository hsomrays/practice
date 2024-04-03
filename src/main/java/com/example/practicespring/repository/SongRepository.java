package com.example.practicespring.repository;

import com.example.practicespring.entity.RecordingStudio;
import com.example.practicespring.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitleContainingIgnoreCase(String title);
}
