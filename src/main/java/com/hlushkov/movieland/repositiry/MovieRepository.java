package com.hlushkov.movieland.repositiry;

import com.hlushkov.movieland.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query(nativeQuery = true, value = "SELECT movies.id, name_russian, name_native, year_of_release, description, " +
            "rating, price, picture_path FROM movies ORDER BY random() limit :count")
    List<Movie> findRandom(@Param("count") int count);
}
