package com.pencorp.domain.repository;

import com.pencorp.domain.Info;

import rx.Observable;

/**
 * Created by Tuane on 5/03/17.
 */

public interface InfoRepository {

    /**
     * Get an {@link rx.Observable} which will emit a {@link Info}.
     *
     */
    Observable<Info> info();

    /**
     * Update the info the info that was Cached
     * @param firstName
     * @param lastName
     * @return the new updated info
     */
    Observable<Info> info(final String firstName, final String lastName);
}
