package com.pencorp.cleanarchitecture.view;

import com.pencorp.cleanarchitecture.model.InfoModel;

/**
 * Created by Tuane on 5/03/17.
 */

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link InfoModel}.
 */
public interface InfoView  extends LoadDataView{

    /**
     * View a {@link InfoModel}
     *
     * @param infoModel The info that will be shown
     */
    void viewInfo(InfoModel infoModel);
}
