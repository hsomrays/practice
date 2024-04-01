package com.example.practicespring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recording_studio")
public class RecordingStudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_name")
    private String studioName;

    private String location;

    @Column(name = "number_of_employees")
    private int numberOfEmployees;

    @Column(name = "recording_engineer_id")
    private Long recordingEngineerId;
}
