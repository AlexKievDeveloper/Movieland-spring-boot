package com.hlushkov.movieland.web.controller;

import com.hlushkov.movieland.entity.Movie;
import com.hlushkov.movieland.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    private final MovieService movieService;

    @GetMapping()
    public List<Movie> findAll() {
        List<Movie> movies = StreamSupport.stream(movieService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        for (Movie movie : movies) {
            log.info("Movie: {}", movie);
        }
        return movies;
    }

}
