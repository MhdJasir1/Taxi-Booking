package com.taita.webapp.taxibooking.exception;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String exception){
        super(exception);
    }
}
