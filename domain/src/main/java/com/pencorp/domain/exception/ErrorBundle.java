package com.pencorp.domain.exception;

/**
 * Created by Tuane on 5/03/17.
 */

/**
 * Interface to represent a wrapper around an {@link java.lang.Exception} to manage errors.
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
