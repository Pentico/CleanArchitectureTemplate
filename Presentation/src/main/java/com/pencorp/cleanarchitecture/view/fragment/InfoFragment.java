package com.pencorp.cleanarchitecture.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.cleanarchitecture.internal.di.components.InfoComponent;
import com.pencorp.cleanarchitecture.model.InfoModel;
import com.pencorp.cleanarchitecture.presenter.InfoPresenter;
import com.pencorp.cleanarchitecture.view.InfoView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Tuane on 5/03/17.
 */

public class InfoFragment  extends BaseFragment implements InfoView{

    @Inject
    InfoPresenter infoPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(InfoComponent.class).inject(this);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        this.infoPresenter.setview(this);
        if(savedInstanceState == null){
            this.loadInfoData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.infoPresenter.resume();
    }

    @Override
    public void onPause(){
        super.onPause();
        this.infoPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.infoPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.infoPresenter = null;
    }

    @Override
    public void viewInfo(InfoModel infoModel) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }
}
