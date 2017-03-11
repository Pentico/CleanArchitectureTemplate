package com.pencorp.cleanarchitecture.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.cleanarchitecture.model.InfoModel;
import com.pencorp.cleanarchitecture.presenter.EditPresenter;
import com.pencorp.cleanarchitecture.view.EditView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tuane on 11/03/17.
 */

public class EditFragment extends BaseFragment implements EditView {

    @Inject
    EditPresenter editPresenter;

    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;
    @Bind(R.id.tv_firstname)
    TextView tv_firstname;
    @Bind(R.id.tv_lastname)
    TextView tv_lastname;


    public EditFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(EditFragment.class).inject(this);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_edit, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        this.editPresenter.setView(this);
        if(savedInstanceState == null){
            this.loadInfoData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.editPresenter.resume();
    }

    @Override
    public void onPause(){
        super.onPause();
        this.editPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.editPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.editPresenter = null;
    }

    @Override
    public void editInfo(InfoModel infoModel) {
        if(infoModel != null) {
            this.tv_firstname.setText(infoModel.getFirstname());
            this.tv_lastname.setText(infoModel.getLastname());
        }
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    /**
     * Load Info
     */
    private void loadInfoData() {
        if(this.editPresenter != null) {
            this.editPresenter.initialize();
        }
    }
}
