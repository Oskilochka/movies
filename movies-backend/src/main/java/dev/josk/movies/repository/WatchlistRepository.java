package dev.josk.movies.repository;

import dev.josk.movies.entity.Movie;
import dev.josk.movies.entity.User;
import dev.josk.movies.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    List<Watchlist> findByUser(User user);
    Optional<Watchlist> findByUserAndMovie(User user, Movie movie);
    void deleteByUserAndMovie(User user, Movie movie);
}
