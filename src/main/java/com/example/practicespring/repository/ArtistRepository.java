package com.example.practicespring.repository;

import com.example.practicespring.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByArtistNameContainingIgnoreCase(String artistName);
    Optional<Artist> findFirstByNameAndAgeAndArtistName(String name, int age, String artistName);
}
