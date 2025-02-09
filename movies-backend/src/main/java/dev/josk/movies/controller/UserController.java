package dev.josk.movies.controller;

import dev.josk.movies.dto.UserDto;
import dev.josk.movies.exception.NotFoundException;
import dev.josk.movies.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "User management")
public class UserController {
     private UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("User with id %s doesn't exist".formatted(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User with id %s was successfully deleted".formatted(id));
    }
}
