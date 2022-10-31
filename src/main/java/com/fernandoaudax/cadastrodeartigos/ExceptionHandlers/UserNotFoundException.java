package com.fernandoaudax.cadastrodeartigos.ExceptionHandlers;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super ("User not found");
    }
}
