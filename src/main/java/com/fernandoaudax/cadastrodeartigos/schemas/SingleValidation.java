package com.fernandoaudax.cadastrodeartigos.schemas;

import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.SingleErrorResponse;
import lombok.Getter;

@Getter
public class SingleValidation {
    private final SingleErrorResponse error;

    public SingleValidation(String message) {
        this.error = new SingleErrorResponse(message);
    }
}
