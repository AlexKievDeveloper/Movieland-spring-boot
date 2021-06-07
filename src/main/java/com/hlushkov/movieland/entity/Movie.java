package com.hlushkov.movieland.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameRussian;
    private String nameNative;
    private String description;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    @JsonCreator
    public static Movie create(Map<String, Object> object) {
        return Movie.builder()
                .nameRussian((String) object.get("nameRussian"))
                .nameNative((String) object.get("nameNative"))
                .description((String) object.get("description"))
                .yearOfRelease((int) object.get("yearOfRelease"))
                .rating((double) object.get("rating"))
                .price((double) object.get("price"))
                .picturePath((String) object.get("picturePath"))
                .build();
    }
}
