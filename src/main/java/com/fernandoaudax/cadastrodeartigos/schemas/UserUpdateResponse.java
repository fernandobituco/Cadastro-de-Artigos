package com.fernandoaudax.cadastrodeartigos.schemas;

import com.fernandoaudax.cadastrodeartigos.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateResponse {
    @NotBlank
    private UUID uuid;

    @NotBlank
    private String username;

    @NotBlank
    private String registeredAt;

    public UserUpdateResponse(User user) {
        this.uuid = user.getUuid();
        this.username = user.getUsername();
        this.registeredAt = user.getRegisteredAt();
    }
}
