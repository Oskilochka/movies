package dev.josk.movies.service.impl;

import dev.josk.movies.dto.RatingDto;
import dev.josk.movies.entity.Rating;
import dev.josk.movies.mapper.RatingMapper;
import dev.josk.movies.repository.RatingRepository;
import dev.josk.movies.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public RatingDto addRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        Rating savedRating = ratingRepository.save(rating);
        return ratingMapper.toDto(savedRating);
    }

    @Override
    public Optional<RatingDto> getRating(Long userId, Long movieId) {
        return ratingRepository.findByUserIdAndMovieId(userId, movieId).map(ratingMapper::toDto);
    }

    @Override
    public Double getAverageRating(Long movieId) {
        return ratingRepository.getScoreByMovieId(movieId).orElse(0.0);
    }
}
