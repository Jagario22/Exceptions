package com.nix.exception;

public class WrongDateException extends RuntimeException{

    private String date;

    public WrongDateException(String message, String date){
        super(message);
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}