package com.fernandoaudax.cadastrodeartigos.ExceptionHandlers;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException() {
        super ("Article not found");
    }
}
