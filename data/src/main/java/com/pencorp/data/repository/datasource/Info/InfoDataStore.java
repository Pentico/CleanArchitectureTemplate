package com.pencorp.data.repository.datasource.Info;

/**
 * Created by Tuane on 5/03/17.
 */

import com.pencorp.data.entity.InfoEntity;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface InfoDataStore {

    /**
     * Get an {@link rx.Observable} which will emit a {@link InfoEntity}
     *
     * @return InfoEnity
     */
    Observable<InfoEntity> infoEntity();
}
