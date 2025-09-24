//package com.example.project_library.entity;
//
//import com.example.project_library.dto.CommentDto;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.UuidGenerator;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//@Table(name = "movies")
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter @Setter
//public class MovieEntity {
//
//    @Id
//    @UuidGenerator
//    private UUID id;
//    private String name;
//    private int year;
//    private double rating;
//    private String description;
//
//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CommentEntity> comments = new ArrayList<>();
//
//}
