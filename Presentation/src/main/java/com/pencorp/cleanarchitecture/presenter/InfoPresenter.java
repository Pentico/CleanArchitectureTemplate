package com.pencorp.cleanarchitecture.presenter;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.pencorp.cleanarchitecture.exception.ErrorMessageFactory;
import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.cleanarchitecture.mapper.InfoModelDataMapper;
import com.pencorp.cleanarchitecture.model.InfoModel;
import com.pencorp.cleanarchitecture.view.InfoView;
import com.pencorp.domain.Info;
import com.pencorp.domain.exception.DefaultErrorBundle;
import com.pencorp.domain.exception.ErrorBundle;
import com.pencorp.domain.interactor.DefaultSubscriber;
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
        this.getView();
    }

    private void showViewLoading() {
        this.viewInfoView.showLoading();
    }

    private void hideViewLoading() {
        this.viewInfoView.hideLoading();
    }

    private void showViewRetry() {
        this.viewInfoView.showRetry();
    }
    private void hideViewRetry() {
        this.viewInfoView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewInfoView.context(),
                errorBundle.getException());
        this.viewInfoView.showError(errorMessage);
    }

    private void showInfoInView(Info info) {
        final InfoModel infoModel = this.infoModelDataMapper.tranform(info);
        this.viewInfoView.viewInfo(infoModel);
    }

    private void getView() {
        this.getInfoUseCase.execute(new InfoSubscriber());
    }

    @RxLogSubscriber
    private final class InfoSubscriber extends DefaultSubscriber<Info> {

        @Override
        public void onCompleted() {
            InfoPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e){
            InfoPresenter.this.hideViewLoading();
            InfoPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            InfoPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Info info) {
            InfoPresenter.this.showInfoInView(info);
        }
    }
}
