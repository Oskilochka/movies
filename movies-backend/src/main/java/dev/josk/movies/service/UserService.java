package dev.josk.movies.service;

import dev.josk.movies.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDto> getById(Long userId);
    List<UserDto> getAll();
    void deleteById(Long userId);
}
