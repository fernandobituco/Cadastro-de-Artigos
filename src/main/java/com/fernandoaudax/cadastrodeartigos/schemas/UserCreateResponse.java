package com.fernandoaudax.cadastrodeartigos.schemas;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class UserCreateResponse {
    @NotBlank
    private UUID uuid;

    @NotBlank
    private String username;

    @NotBlank
    private String registeredAt;
}
