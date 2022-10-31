package com.fernandoaudax.cadastrodeartigos.ExceptionHandlers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleErrorResponse {

    private final String message;
    public SingleErrorResponse(String message) {
        this.message = message;
    }
}
