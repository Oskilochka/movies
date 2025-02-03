package dev.josk.movies.service;

import dev.josk.movies.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto addReview(ReviewDto reviewDto);
    List<ReviewDto> getReviewsByMovie(Long movieId);
}
