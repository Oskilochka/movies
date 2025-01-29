package dev.josk.movies.repository;

import dev.josk.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SearchRepository extends JpaRepository<Movie, Long> {
}
