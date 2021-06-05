package com.hlushkov.movieland.service;

import com.hlushkov.movieland.entity.Movie;

public interface MovieService {
    Iterable<Movie> findAll();
}
