package it.imperato.test.security.exception;

public class UsersManagerException extends RuntimeException {

    public UsersManagerException() {

    }

    public UsersManagerException(String message) {
        super(message);
    }

    public UsersManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
