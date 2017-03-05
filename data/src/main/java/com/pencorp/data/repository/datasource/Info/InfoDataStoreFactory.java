package com.pencorp.data.repository.datasource.Info;

import android.content.Context;
import android.support.annotation.NonNull;

import com.pencorp.data.cache.InfoCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 5/03/17.
 */

@Singleton
public class InfoDataStoreFactory {

    private final Context context;
    private final InfoCache infoCache;

    @Inject
    public InfoDataStoreFactory(@NonNull Context context, @NonNull InfoCache infoCache) {
        this.context = context.getApplicationContext();
        this.infoCache = infoCache;
    }

    /**
     * Create a {@link InfoDataStore}
     */
    public InfoDataStore create() {
        InfoDataStore infoDataStore;

        infoDataStore = new DiskInfoDataStore(this.infoCache);
    }
}
