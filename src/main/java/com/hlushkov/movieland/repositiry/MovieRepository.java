package com.hlushkov.movieland.repositiry;

import com.hlushkov.movieland.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
