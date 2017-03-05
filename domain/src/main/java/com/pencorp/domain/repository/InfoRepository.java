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
}
