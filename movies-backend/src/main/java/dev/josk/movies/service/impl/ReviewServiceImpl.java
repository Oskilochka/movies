package dev.josk.movies.service.impl;

import dev.josk.movies.dto.ReviewDto;
import dev.josk.movies.entity.Review;
import dev.josk.movies.mapper.ReviewMapper;
import dev.josk.movies.repository.ReviewRepository;
import dev.josk.movies.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository commentRepository;
    private final ReviewMapper commentMapper;

    @Override
    public ReviewDto addReview(ReviewDto commentDto) {
        Review comment = commentMapper.toEntity(commentDto);
        Review savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }

    @Override
    public List<ReviewDto> getReviewsByMovie(Long movieId) {
        return commentRepository.findByMovieId(movieId).stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
}
