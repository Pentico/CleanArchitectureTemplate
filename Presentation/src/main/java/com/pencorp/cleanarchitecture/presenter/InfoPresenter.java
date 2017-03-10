package com.pencorp.cleanarchitecture.presenter;

import android.support.annotation.NonNull;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.cleanarchitecture.mapper.InfoModelDataMapper;
import com.pencorp.cleanarchitecture.view.InfoView;
import com.pencorp.domain.interactor.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tuane on 5/03/17.
 */
@PerActivity
public class InfoPresenter implements Presenter {

    private InfoView viewInfoView;

    private final UseCase getInfoUseCase;
    private final InfoModelDataMapper infoModelDataMapper;

    @Inject
    public InfoPresenter(@Named("info") UseCase getInfoUseCase, InfoModelDataMapper infoModelDataMapper) {
        this.getInfoUseCase = getInfoUseCase;
        this.infoModelDataMapper = infoModelDataMapper;
    }

    public void setView(@NonNull InfoView view) {
        this.viewInfoView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getInfoUseCase.unsubscribe();
        this.viewInfoView = null;
    }

    /**
     * Initializes the presenter by start retrieving info details.
     */
    public void initialize() {
        this.loadInfo();
    }

    /**
     * Load Info
     */
    private void loadInfo() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getUserDetails();
    }

    private void showViewLoading() {
        this.viewInfoView.showLoading();
    }


}
