package dev.josk.movies.repository;

import dev.josk.movies.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);
    Optional<Double> getScoreByMovieId(Long movieId);
}
