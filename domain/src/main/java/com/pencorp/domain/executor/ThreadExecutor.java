package com.pencorp.domain.executor;

/**
 * Created by Tuane on 5/03/17.
 */

import java.util.concurrent.Executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link com.pencorp.domain.interactor.UseCase} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {}
