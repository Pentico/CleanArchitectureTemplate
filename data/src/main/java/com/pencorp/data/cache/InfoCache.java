package com.pencorp.data.cache;

/**
 * Created by Tuane on 5/03/17.
 */

import rx.Observable;

/**
 * An interface representing a info Cache.
 */
public interface InfoCache {

    /**
     * Gets an {@link rx.Observable} which will emit a {@link InfoEntity}.
     *
     */
    Observable<InfoEntity> get();

    /**
     * Puts and element into the cache.
     *
     * @param InfoEntity Element to insert in the cache.
     */
    void put(InfoEntity infoEntity);

    /**
     * Checks if an element exists in the cache.
     *
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached();

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
