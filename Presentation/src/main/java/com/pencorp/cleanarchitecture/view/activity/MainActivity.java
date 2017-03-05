package com.pencorp.cleanarchitecture.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.pencorp.cleanarchitecture.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_LoadData)
    Button btn_loadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Goes to the Info screen.
     */
    @OnClick(R.id.btn_LoadData)
    void navigateToInfo() {
        this.navigator.navigateToInfo(this);
    }
}
