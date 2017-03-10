package com.pencorp.cleanarchitecture.internal.di.modules;

/**
 * Created by Tuane on 5/03/17.
 */

import android.content.Context;

import com.pencorp.cleanarchitecture.AndroidApplication;
import com.pencorp.cleanarchitecture.UIThread;
import com.pencorp.data.cache.InfoCache;
import com.pencorp.data.cache.InfoCacheImpl;
import com.pencorp.data.executor.JobExecutor;
import com.pencorp.data.repository.InfoDataRepository;
import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.InfoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    InfoRepository provideInfoRepository(InfoDataRepository infoRepository) {
        return infoRepository;
    }

    @Provides
    @Singleton
    InfoCache provideUserCache(InfoCacheImpl infoCache) {
        return infoCache;
    }

}
