package com.pencorp.cleanarchitecture.mapper;

import com.pencorp.cleanarchitecture.internal.di.PerActivity;
import com.pencorp.cleanarchitecture.model.InfoModel;
import com.pencorp.domain.Info;

import javax.inject.Inject;

/**
 * Created by Tuane on 5/03/17.
 */

@PerActivity
public class InfoModelDataMapper {

    @Inject
    InfoModelDataMapper(){}

    /**
     * Transform a {@link Info} into an {@link InfoModel}
     * @param info Object to be transformed
     * @return {@link InfoModel}
     */
    public InfoModel tranform(Info info) {
        if(info == null) {
            throw new IllegalArgumentException("Cannot transform a null value");

        }
        InfoModel infoModel = new InfoModel();
        infoModel.setFirstname(info.getFirstname());
        infoModel.setLastname(info.getLastname());

        return infoModel;
    }

}
