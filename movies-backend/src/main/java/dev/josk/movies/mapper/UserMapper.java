package dev.josk.movies.mapper;

import dev.josk.movies.dto.UserDto;
import dev.josk.movies.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDTO);
}
