package com.pencorp.cleanarchitecture.presenter;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.pencorp.cleanarchitecture.exception.ErrorMessageFactory;
import com.pencorp.cleanarchitecture.mapper.InfoModelDataMapper;
import com.pencorp.cleanarchitecture.model.InfoModel;
import com.pencorp.cleanarchitecture.view.EditView;
import com.pencorp.domain.Info;
import com.pencorp.domain.exception.DefaultErrorBundle;
import com.pencorp.domain.exception.ErrorBundle;
import com.pencorp.domain.interactor.DefaultSubscriber;
import com.pencorp.domain.interactor.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tuane on 11/03/17.
 */

public class EditPresenter implements Presenter {

    private EditView viewEditView;

    private final UseCase getEditUseCase;
    private final InfoModelDataMapper infoModelDataMapper;

    @Inject
    public EditPresenter(@Named("edit") UseCase getEditUseCase, InfoModelDataMapper infoModelDataMapper) {
        this.getEditUseCase = getEditUseCase;
        this.infoModelDataMapper = infoModelDataMapper;
    }

    public void setView(@NonNull EditView view) {
        this.viewEditView = view;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

        this.getEditUseCase.unsubscribe();
        this.viewEditView = null;
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
        this.viewEditView.showLoading();
    }

    private void hideViewLoading() {
        this.viewEditView.hideLoading();
    }

    private void showViewRetry() {
        this.viewEditView.showRetry();
    }
    private void hideViewRetry() {
        this.viewEditView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.viewEditView.context(),
                errorBundle.getException());
        this.viewEditView.showError(errorMessage);
    }

    private void showInfoInView(Info info) {
        final InfoModel infoModel = this.infoModelDataMapper.tranform(info);
        this.viewEditView.editInfo(infoModel);
    }

    private void getView() {
        this.getEditUseCase.execute(new EditSubscriber());
    }

    @RxLogSubscriber
    private final class EditSubscriber extends DefaultSubscriber<Info> {

        @Override
        public void onCompleted() {
            EditPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e){
            EditPresenter.this.hideViewLoading();
            EditPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            EditPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Info info) {
            EditPresenter.this.showInfoInView(info);
        }
    }
}
