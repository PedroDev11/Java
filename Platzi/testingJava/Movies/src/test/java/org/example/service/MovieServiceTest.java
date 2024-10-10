package org.example.service;

import org.example.data.MovieRepository;
import org.example.models.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.models.Genre.*;
import static org.junit.Assert.assertThat;

public class MovieServiceTest {

    @Test
    public void moviesByGenre() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        // Cuando al repository manden a llamar el metodo findAll(), se retornara una lista de peliculas
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );

        MovieService movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);

        // Se configue los ids, mapear cada pelicula a su id, con stream y esto lo collecto
        // en una lista
        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        // Se comprueba mediante el id
        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3, 6)));
    }
}