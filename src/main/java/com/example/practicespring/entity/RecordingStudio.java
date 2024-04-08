package com.example.practicespring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "recording_studio_artist",
            joinColumns = @JoinColumn(name = "recording_studio_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    @JsonIgnoreProperties("recordingStudios")
    private List<Artist> artists;

}
