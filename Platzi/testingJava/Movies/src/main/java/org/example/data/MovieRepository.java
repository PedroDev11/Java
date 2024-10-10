package org.example.data;

import org.example.models.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveMovie(Movie movie);
}
