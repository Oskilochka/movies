package dev.josk.movies.service;

import dev.josk.movies.dto.RatingDto;

import java.util.Optional;

public interface RatingService {
    RatingDto addRating(RatingDto ratingDto);
    Optional<RatingDto> getRating(Long userId, Long movieId);
    Double getAverageRating(Long movieId);
}
