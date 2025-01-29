package dev.josk.movies.repository;

import dev.josk.movies.entity.Movie;
import dev.josk.movies.entity.User;
import dev.josk.movies.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
