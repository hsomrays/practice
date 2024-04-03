package com.example.practicespring.repository;

import com.example.practicespring.entity.Artist;
import com.example.practicespring.entity.RecordingStudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByArtistNameContainingIgnoreCase(String artistName);
}
