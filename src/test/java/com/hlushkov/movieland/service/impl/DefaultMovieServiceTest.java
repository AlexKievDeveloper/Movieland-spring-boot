package com.hlushkov.movieland.service.impl;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.hlushkov.movieland.config.MovielandPostgresqlContainer;
import com.hlushkov.movieland.data.TestData;
import com.hlushkov.movieland.entity.Movie;
import com.hlushkov.movieland.service.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {MovielandPostgresqlContainer.Initializer.class})
class DefaultMovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    @DataSet(provider = TestData.MovieProvider.class, cleanAfter = true)
    @DisplayName("Returns list with all movies from DB")
    void findAll() {
        //when
        List<Movie> actualMovieList = movieService.findAll();
        //then
        assertNotNull(actualMovieList);
        assertEquals(2, actualMovieList.size());
    }
}