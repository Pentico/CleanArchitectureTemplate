package com.pencorp.cleanarchitecture.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.cleanarchitecture.internal.di.HasComponent;
import com.pencorp.cleanarchitecture.internal.di.components.InfoComponent;
import com.pencorp.cleanarchitecture.view.fragment.InfoFragment;

/**
 * Created by Tuane on 10/03/17.
 */

public class Info2 extends BaseActivity implements HasComponent<InfoComponent> {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, Info2.class);
    }

    private InfoComponent infoComponent;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new InfoFragment());
        }
    }

    @Override
    public InfoComponent getComponent() {
        return null;
    }
}
