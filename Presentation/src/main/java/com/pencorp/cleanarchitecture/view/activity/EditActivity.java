package com.pencorp.cleanarchitecture.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.cleanarchitecture.internal.di.HasComponent;
import com.pencorp.cleanarchitecture.internal.di.components.DaggerInfoComponent;
import com.pencorp.cleanarchitecture.internal.di.components.InfoComponent;
import com.pencorp.cleanarchitecture.internal.di.modules.InfoModule;
import com.pencorp.cleanarchitecture.view.fragment.EditFragment;
import com.pencorp.cleanarchitecture.view.fragment.InfoFragment;

/**
 * Created by Tuane on 11/03/17.
 */

public class EditActivity extends BaseActivity implements HasComponent<InfoComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, EditActivity.class);
    }

    private InfoComponent infoComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);
        this.initializeInjector();
        if(savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new EditFragment());
        }
    }

    public void initializeInjector() {
        this.infoComponent = DaggerInfoComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .infoModule(new InfoModule())
                .build();
    }

    @Override
    public InfoComponent getComponent() {
        return infoComponent;
    }

}
