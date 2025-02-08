package dev.josk.movies.service.impl;

import dev.josk.movies.dto.MovieDto;
import dev.josk.movies.entity.Movie;
import dev.josk.movies.exception.NotFoundException;
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
    public Optional<MovieDto> getById(Long movieId) {
        return movieRepository.findById(movieId).map(movieMapper::toDto);
    }

    @Override
    public List<MovieDto> getAll() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDto(savedMovie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie existingMovie = findExistingUser(id);

        existingMovie.setTitle(movieDto.getTitle());
        existingMovie.setReleaseDate(movieDto.getReleaseDate());
        existingMovie.setDescription(movieDto.getDescription());
        existingMovie.setGenres(movieDto.getGenres());
        existingMovie.setPosterUrl(movieDto.getPosterUrl());
        existingMovie.setTrailerUrl(movieDto.getTrailerUrl());

        Movie savedMovie = movieRepository.save(existingMovie);

        return movieMapper.toDto(savedMovie);
    }

    @Override
    public void deleteById(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    private Movie findExistingUser(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie not found with id: " + id));
    }
}
