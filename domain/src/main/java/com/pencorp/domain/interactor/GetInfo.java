package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.InfoRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tuane on 5/03/17.
 */

public class GetInfo extends UseCase {

    private final InfoRepository infoRepository;

    @Inject
    public GetInfo(InfoRepository infoRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.infoRepository = infoRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.infoRepository.info();
    }
}
