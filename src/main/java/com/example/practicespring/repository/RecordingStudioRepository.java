package com.example.practicespring.repository;

import com.example.practicespring.entity.RecordingStudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordingStudioRepository extends JpaRepository<RecordingStudio, Long> {
    Optional<RecordingStudio> findByStudioNameContainingIgnoreCase(String studioName);
}
