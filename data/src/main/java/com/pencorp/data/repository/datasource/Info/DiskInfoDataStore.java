package com.pencorp.data.repository.datasource.Info;

import com.pencorp.data.cache.InfoCache;
import com.pencorp.data.entity.InfoEntity;

import rx.Observable;

/**
 * Created by Tuane on 5/03/17.
 */

public class DiskInfoDataStore implements InfoDataStore {

    private final InfoCache infoCache;

    /**
     * Construct a {@link InfoDataStore} based file system data store.
     *
     * @param infoCache A {@link InfoCache} to cache data retrieved from the api.
     */
    public DiskInfoDataStore(InfoCache infoCache) {
        this.infoCache = infoCache;
    }

    @Override public Observable<InfoEntity> infoEntity() {
        return this.infoCache.get();
    }
}
