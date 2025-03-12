package dev.sorokin.event.notificator.exception;

public class NotRetryableException extends RuntimeException {
    public NotRetryableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotRetryableException(Throwable cause) {
        super(cause);
    }
}
