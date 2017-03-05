package com.pencorp.cleanarchitecture.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.cleanarchitecture.internal.di.HasComponent;
import com.pencorp.cleanarchitecture.internal.di.components.DaggerActivityComponent;
import com.pencorp.cleanarchitecture.internal.di.components.InfoComponent;
import com.pencorp.cleanarchitecture.view.fragment.InfoFragment;

/**
 * Created by Tuane on 5/03/17.
 */

public class InfoActivity extends BaseActivity implements HasComponent {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, InfoActivity.class);
    }

    private InfoComponent infoComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        this.initializeInjector();
        if(savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new InfoFragment());
        }
    }

    @Override
    public void initializeInjector() {
        this.infoComponent = DaggerInfoComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public Object getComponent() {
        return null;
    }
}
