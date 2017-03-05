package com.pencorp.cleanarchitecture.internal.di;

/**
 * Created by Tuane on 5/03/17.
 */

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
    C getComponent();
}
