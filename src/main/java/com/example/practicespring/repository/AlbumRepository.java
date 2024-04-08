package com.example.practicespring.repository;

import com.example.practicespring.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByTitleContainingIgnoreCase(String title);
}
