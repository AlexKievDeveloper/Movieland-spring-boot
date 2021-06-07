package com.hlushkov.movieland.service.impl;

import com.hlushkov.movieland.entity.Movie;
import com.hlushkov.movieland.repositiry.MovieRepository;
import com.hlushkov.movieland.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return StreamSupport
                .stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findRandom(int randomMovieCount) {
        return movieRepository.findRandom(randomMovieCount);
    }
}
