package dev.josk.movies.movie;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getById(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> getByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
