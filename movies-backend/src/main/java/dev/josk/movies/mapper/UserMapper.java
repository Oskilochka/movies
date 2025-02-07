package dev.josk.movies.mapper;

import dev.josk.movies.dto.UserDto;
import dev.josk.movies.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDTO);
}
