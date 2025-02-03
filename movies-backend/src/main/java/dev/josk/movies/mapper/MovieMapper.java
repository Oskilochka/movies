package dev.josk.movies.mapper;

import dev.josk.movies.dto.MovieDto;
import dev.josk.movies.entity.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto toDto(Movie movie);

    @InheritInverseConfiguration
    Movie toEntity(MovieDto movieDTO);
}
