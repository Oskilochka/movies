package dev.josk.movies.controller;

import dev.josk.movies.dto.RatingDto;
import dev.josk.movies.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
@Tag(name = "Rating Controller")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    @Operation(summary = "Rate film")
    public ResponseEntity<RatingDto> rateMovie(@RequestBody @Valid RatingDto ratingDto) {
        RatingDto ratedMovie = ratingService.addRating(ratingDto);
        return ResponseEntity.ok(ratedMovie);
    }

    @GetMapping("/{movieId}/average")
    @Operation(summary = "Get average rate")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long movieId) {
        Double averageRating = ratingService.getAverageRating(movieId);
        return ResponseEntity.ok(averageRating);
    }
}
