package dev.josk.movies.service;

import dev.josk.movies.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    Optional<UserDto> getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
