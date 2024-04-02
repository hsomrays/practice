package com.example.practicespring.repository;

import com.example.practicespring.entity.RecordingStudio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingStudioRepository extends JpaRepository<RecordingStudio, Long> {
}
