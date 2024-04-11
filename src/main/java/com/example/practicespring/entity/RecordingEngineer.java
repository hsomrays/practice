package com.example.practicespring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recording_engineer")
public class RecordingEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "work_experience")
    private int workExperience;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "recording_studio_id")
    private RecordingStudio recordingStudio;
}