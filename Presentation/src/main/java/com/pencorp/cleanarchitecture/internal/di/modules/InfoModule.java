package com.pencorp.cleanarchitecture.internal.di.modules;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.domain.interactor.EditInfo;
import com.pencorp.domain.interactor.GetInfo;
import com.pencorp.domain.interactor.UseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuane on 5/03/17.
 */

@Module
public class InfoModule {

    public InfoModule(){}

    @Provides
    @PerActivity
    @Named("info")
    UseCase provideGetInfoUseCase(
            GetInfo getInfo) {
        return getInfo;
    }

    @Provides
    @PerActivity
    @Named("Edit")
    UseCase provideEditInfoUseCase(
            EditInfo editInfo) {
        return editInfo;
    }
}
