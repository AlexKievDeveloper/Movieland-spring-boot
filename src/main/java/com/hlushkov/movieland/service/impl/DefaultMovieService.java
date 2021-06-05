package com.hlushkov.movieland.service.impl;

import com.hlushkov.movieland.entity.Movie;
import com.hlushkov.movieland.repositiry.MovieRepository;
import com.hlushkov.movieland.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }
}
