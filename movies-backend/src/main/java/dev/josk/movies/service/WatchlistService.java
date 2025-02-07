package dev.josk.movies.service;

import dev.josk.movies.dto.MovieDto;

import java.util.List;

public interface WatchlistService {
    void addToWatchlist(Long userId, Long movieId);
    void removeFromWatchlist(Long userId, Long movieId);
    List<MovieDto> getWatchlist(Long userId);
}
