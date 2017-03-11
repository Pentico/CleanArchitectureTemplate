package com.pencorp.cleanarchitecture.view;

/**
 * Created by Tuane on 11/03/17.
 */

import com.pencorp.cleanarchitecture.model.InfoModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link InfoModel}.
 */
public interface EditView extends LoadDataView {

    /**
     * Render a inof in the UI.
     *
     * @param infoModel The {@link InfoModel} that will be shown.
     */
    void editInfo(InfoModel infoModel);
}
