package com.pencorp.cleanarchitecture.view;

import com.pencorp.cleanarchitecture.model.InfoModel;

/**
 * Created by Tuane on 5/03/17.
 */

public interface InfoView  extends LoadDataView{

    /**
     * View a {@link InfoModel}
     *
     * @param infoModel The info that will be shown
     */
    void viewInfo(InfoModel infoModel);
}
