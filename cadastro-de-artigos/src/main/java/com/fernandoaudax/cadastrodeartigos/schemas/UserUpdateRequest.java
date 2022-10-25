package com.fernandoaudax.cadastrodeartigos.schemas;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateRequest {
    @NotBlank
    @Size(min = 3, max = 150, message = "The username must be 3 to 150 characters long")
    private String username;

    @NotBlank
    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;
}
