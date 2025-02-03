package dev.josk.movies.mapper;

import dev.josk.movies.dto.ReviewDto;
import dev.josk.movies.entity.Review;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(Review review);

    @InheritInverseConfiguration
    Review toEntity(ReviewDto reviewDto);
}
