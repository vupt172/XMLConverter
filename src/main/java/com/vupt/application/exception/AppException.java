package com.vupt.application.exception;

public class AppException extends RuntimeException{
    public AppException(String message) {
        super(message);
    }
    public AppException(String message,StackTraceElement[] stackTraceElements){
        super(message);
        this.setStackTrace(stackTraceElements);
    }
}
