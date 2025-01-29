package dev.josk.movies.repository;

import dev.josk.movies.entity.Movie;
import dev.josk.movies.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}
