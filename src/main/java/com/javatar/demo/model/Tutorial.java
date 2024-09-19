package com.javatar.demo.model;

import jakarta.persistence.*; // for Spring Boot 3
import lombok.Data;

@Data
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Boolean published;
}
