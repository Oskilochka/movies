package dev.josk.movies.service;

import dev.josk.movies.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieDto createMovie(MovieDto movieDto);
    Optional<MovieDto> getMovieById(Long movieId);
    List<MovieDto> getAllMovies();
    void deleteMovie(Long movieId);
}
