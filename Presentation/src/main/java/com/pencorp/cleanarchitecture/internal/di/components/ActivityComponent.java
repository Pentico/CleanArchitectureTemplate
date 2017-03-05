package com.pencorp.cleanarchitecture.internal.di.components;

/**
 * Created by Tuane on 5/03/17.
 */

import android.app.Activity;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.cleanarchitecture.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
