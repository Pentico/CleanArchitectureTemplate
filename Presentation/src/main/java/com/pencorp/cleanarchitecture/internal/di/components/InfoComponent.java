package com.pencorp.cleanarchitecture.internal.di.components;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.cleanarchitecture.internal.di.modules.ActivityModule;
import com.pencorp.cleanarchitecture.internal.di.modules.InfoModule;
import com.pencorp.cleanarchitecture.view.fragment.InfoFragment;

import dagger.Component;

/**
 * Created by Tuane on 5/03/17.
 */

/**
 * A scope {@link PerActivity} component.
 *
 * Injects info specific Fragments
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
    modules = {ActivityModule.class, InfoModule.class})
public interface InfoComponent extends ActivityComponent {
    void inject(InfoFragment infoFragment);
}
