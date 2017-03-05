package com.pencorp.cleanarchitecture.internal.di.modules;

/**
 * Created by Tuane on 5/03/17.
 */


import android.app.Activity;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
