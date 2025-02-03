package dev.josk.movies.mapper;

import dev.josk.movies.dto.RatingDto;
import dev.josk.movies.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingDto toDto(Rating rating);

    @InheritInverseConfiguration
    Rating toEntity(RatingDto ratingDTO);
}
