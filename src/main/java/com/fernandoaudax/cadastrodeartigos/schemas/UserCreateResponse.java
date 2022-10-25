package com.fernandoaudax.cadastrodeartigos.schemas;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class UserCreateResponse {
    @NotBlank
    private UUID uuid;

    @NotBlank
    private String username;

    @NotBlank
    private String registeredAt;
}
