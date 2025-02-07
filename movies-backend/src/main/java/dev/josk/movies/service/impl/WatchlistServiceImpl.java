package dev.josk.movies.service.impl;

import dev.josk.movies.dto.MovieDto;
import dev.josk.movies.entity.Movie;
import dev.josk.movies.entity.User;
import dev.josk.movies.entity.Watchlist;
import dev.josk.movies.mapper.MovieMapper;
import dev.josk.movies.repository.MovieRepository;
import dev.josk.movies.repository.UserRepository;
import dev.josk.movies.repository.WatchlistRepository;
import dev.josk.movies.service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final MovieMapper movieMapper;

    @Override
    public void addToWatchlist(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Watchlist watchlist = new Watchlist(null, user, movie);
        watchlistRepository.save(watchlist);
    }

    @Override
    public void removeFromWatchlist(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        watchlistRepository.deleteByUserAndMovie(user, movie);
    }

    @Override
    public List<MovieDto> getWatchlist(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return watchlistRepository.findByUser(user).stream()
                .map(watchlist -> movieMapper.toDto(watchlist.getMovie()))
                .collect(Collectors.toList());
    }
}
