package dev.josk.movies.controller;

import dev.josk.movies.dto.ReviewDto;
import dev.josk.movies.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Tag(name = "Review Controller", description = "Review management")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @Operation(summary = "Add a review")
    public ResponseEntity<ReviewDto> addComment(@RequestBody @Valid ReviewDto commentDTO) {
        ReviewDto createdComment = reviewService.addReview(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping("/{movieId}")
    @Operation(summary = "Get all reviews for movie")
    public ResponseEntity<List<ReviewDto>> getCommentsByMovie(@PathVariable Long movieId) {
        List<ReviewDto> comments = reviewService.getReviewsByMovieId(movieId);
        return ResponseEntity.ok(comments);
    }
}
