
package dev.josk.movies.controller;

import dev.josk.movies.dto.MovieDto;
import dev.josk.movies.exception.NotFoundException;
import dev.josk.movies.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@RequiredArgsConstructor
@Tag(name = "Movie Controller", description = "Films management")
public class MovieController {
     private MovieService movieService;

    @GetMapping
    @Operation(summary = "Get all films")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movies = movieService.getAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Receive film by id")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        return movieService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Film with id %s was not found".formatted(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Add new film (only for admins)")
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieDto movieDTO) {
        MovieDto createdMovie = movieService.addMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update the film (only for admins)")
    public ResponseEntity<MovieDto> updateMovieById(@PathVariable Long id, @RequestBody @Valid MovieDto movieDTO) {
        MovieDto updatedMovie = movieService.updateMovie(id, movieDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMovie);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete film by id(only for admins)")
    private ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
