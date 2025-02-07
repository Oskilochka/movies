package dev.josk.movies.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    @Email
    @NotBlank(message = "Email shouldn't be empty")
    private String username;

    @NotBlank(message = "Password shouldn't be empty")
    private String password;
}
