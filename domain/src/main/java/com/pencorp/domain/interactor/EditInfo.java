package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.InfoRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tuane on 11/03/17.
 */

public class EditInfo extends UseCase {

    private final InfoRepository infoRepository;
    private final String firstName;
    private final String lastName;

    @Inject
    public EditInfo(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                    InfoRepository infoRepository, String firstName, String lastName) {
        super(threadExecutor, postExecutionThread);
        this.infoRepository = infoRepository;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.infoRepository.info(firstName,lastName);
    }
}
