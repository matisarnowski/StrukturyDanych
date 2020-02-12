package com.company;

public class ListEmptyException extends RuntimeException{
    public ListEmptyException() {
        super("Błąd! Lista pusta!");
    }
}
