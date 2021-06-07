package com.hlushkov.movieland.repositiry;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hlushkov.movieland.config.MovielandPostgresqlContainer;
import com.hlushkov.movieland.data.TestData;
import com.hlushkov.movieland.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@SpringBootTest
@ContextConfiguration(initializers = {MovielandPostgresqlContainer.Initializer.class})
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;
    @Value("${movie.random.count}")
    private int randomMovieCount;

    @Test
    @DataSet(provider = TestData.MovieProvider.class, cleanAfter = true)
    @DisplayName("Returns list with all movies from DB")
    void findAll() {
        //prepare

        //when
        Iterable<Movie> actualIterable = movieRepository.findAll();
        //then
        List<Movie> actualMovieList = StreamSupport
                .stream(actualIterable.spliterator(), false)
                .collect(Collectors.toList());
        assertNotNull(actualMovieList);
        assertEquals(2, actualMovieList.size());
    }

    @Test
    @DataSet(provider = TestData.MoviesProvider.class, cleanAfter = true)
    @DisplayName("Returns list with random movies from DB")
    void findRandom() {
        //when
        List<Movie> actualMovieList = movieRepository.findRandom(randomMovieCount);
        //then
        assertNotNull(actualMovieList);
        assertEquals(3, actualMovieList.size());
    }
}