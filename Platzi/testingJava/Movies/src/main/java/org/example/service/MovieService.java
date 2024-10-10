package org.example.service;

import org.example.data.MovieRepository;
import org.example.models.Genre;
import org.example.models.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll()
                .stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }
}
