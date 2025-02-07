package dev.josk.movies.service.impl;

import dev.josk.movies.dto.MovieDto;
import dev.josk.movies.entity.Movie;
import dev.josk.movies.mapper.MovieMapper;
import dev.josk.movies.repository.MovieRepository;
import dev.josk.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDto(savedMovie);
    }

    @Override
    public Optional<MovieDto> getMovieById(Long movieId) {
        return movieRepository.findById(movieId).map(movieMapper::toDto);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
