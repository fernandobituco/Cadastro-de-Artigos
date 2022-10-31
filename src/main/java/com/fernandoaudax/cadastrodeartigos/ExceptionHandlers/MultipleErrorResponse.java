package com.fernandoaudax.cadastrodeartigos.ExceptionHandlers;

import lombok.Getter;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class MultipleErrorResponse {

    private final String message;

    private final Map<String, String> details;

    public MultipleErrorResponse(String message, Throwable throwable) {
        this.message = message;
        this.details = buildDetails(throwable);
    }

    private Map<String, String> buildDetails(Throwable throwable){
        Throwable current = throwable;
        while (current != null && !(current instanceof ConstraintViolationException)) {
            current = current.getCause();
        }
        final Map<String, String> map = new HashMap<>();
        if(current == null) {
            throw new RuntimeException();
        }
        ((ConstraintViolationException) current).getConstraintViolations().forEach(i -> map.put(i.getPropertyPath().toString(), i.getMessageTemplate()));
        return map;
    }
}
