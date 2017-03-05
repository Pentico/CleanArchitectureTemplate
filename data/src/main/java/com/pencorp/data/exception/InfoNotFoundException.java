package com.pencorp.data.exception;

/**
 * Created by Tuane on 5/03/17.
 */

public class InfoNotFoundException extends Exception {

    public InfoNotFoundException() {
        super();
    }

    public InfoNotFoundException(final String message) {
        super(message);
    }

    public InfoNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InfoNotFoundException(final Throwable cause) {
        super(cause);
    }
}
