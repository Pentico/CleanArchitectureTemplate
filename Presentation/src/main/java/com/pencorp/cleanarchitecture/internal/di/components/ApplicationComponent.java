package com.pencorp.cleanarchitecture.internal.di.components;

/**
 * Created by Tuane on 5/03/17.
 */

import android.content.Context;

import com.pencorp.cleanarchitecture.internal.di.modules.ApplicationModule;
import com.pencorp.cleanarchitecture.view.activity.BaseActivity;
import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

}
