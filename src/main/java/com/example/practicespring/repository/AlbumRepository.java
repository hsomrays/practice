package com.example.practicespring.repository;

import com.example.practicespring.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
