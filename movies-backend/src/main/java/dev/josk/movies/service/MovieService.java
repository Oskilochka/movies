package dev.josk.movies.service;

import dev.josk.movies.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<MovieDto> getById(Long movieId);
    List<MovieDto> getAll();
    MovieDto addMovie(MovieDto movieDto);
    MovieDto updateMovie(Long id, MovieDto movieDto);
    void deleteById(Long movieId);
}
