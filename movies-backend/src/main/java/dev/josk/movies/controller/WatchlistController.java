package dev.josk.movies.controller;

import dev.josk.movies.service.WatchlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/watchlist")
@RequiredArgsConstructor
@Tag(name = "Watchlist Controller", description = "Watchlist management")
public class WatchlistController {
    private final WatchlistService watchlistService;

    @PostMapping("/{movieId}")
    @Operation(summary = "Add a film to the watchlist")
    public ResponseEntity<Void> addToWatchlist(@PathVariable Long movieId, @RequestParam Long userId) {
        watchlistService.addToWatchlist(userId, movieId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{movieId}")
    @Operation(summary = "Remove a film to the watchlist")
    public ResponseEntity<Void> removeFromWatchlist(@PathVariable Long movieId, @RequestParam Long userId) {
        watchlistService.removeFromWatchlist(userId, movieId);
        return ResponseEntity.ok().build();
    }
}
