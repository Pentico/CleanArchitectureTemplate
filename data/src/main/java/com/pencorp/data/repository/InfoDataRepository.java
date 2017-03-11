package com.pencorp.data.repository;

/**
 * Created by Tuane on 5/03/17.
 */

import com.pencorp.data.entity.mapper.InfoEntityDataMapper;
import com.pencorp.data.repository.datasource.Info.InfoDataStore;
import com.pencorp.data.repository.datasource.Info.InfoDataStoreFactory;
import com.pencorp.domain.Info;
import com.pencorp.domain.repository.InfoRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link com.pencorp.domain.repository.InfoRepository} for retrieving user data.
 */
@Singleton
public class InfoDataRepository implements InfoRepository{

    private final InfoDataStoreFactory infoDataStoreFactory;
    private final InfoEntityDataMapper infoEntityDataMapper;

    @Inject
    public InfoDataRepository(InfoDataStoreFactory infoDataStoreFactory,
                              InfoEntityDataMapper infoEntityDataMapper) {
        this.infoDataStoreFactory = infoDataStoreFactory;
        this.infoEntityDataMapper = infoEntityDataMapper;
    }

    @Override
    public Observable<Info> info() {
        final InfoDataStore infoDataStore = this.infoDataStoreFactory.create();

        return infoDataStore.infoEntity().map(this.infoEntityDataMapper::transform);
    }

    @Override
    public Observable<Info> info(String firstName, String lastName) {

        final InfoDataStore infoDataStore = this.infoDataStoreFactory.create(firstName, lastName);
        return infoDataStore.infoEntity().map(this.infoEntityDataMapper::transform);
    }

}
