package com.fernandoaudax.cadastrodeartigos.schemas;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserUpdateRequest {
    @Size(min = 3, max = 150, message = "The username must be 3 to 150 characters long")
    private String username;

    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;
}
