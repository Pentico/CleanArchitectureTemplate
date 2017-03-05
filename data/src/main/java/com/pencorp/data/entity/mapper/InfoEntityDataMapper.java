package com.pencorp.data.entity.mapper;

import com.pencorp.data.entity.InfoEntity;
import com.pencorp.domain.Info;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 5/03/17.
 */

@Singleton
public class InfoEntityDataMapper {

    @Inject
    public InfoEntityDataMapper() {
    }

    /**
     * Transform a {@link InfoEntity} into an {@link Info}
     *
     * @param infoEntity Object to be transsfromed
     * @return {@link Info} if valid {@link InfoEntity} otherwise null
     */
    public Info transform(InfoEntity infoEntity){
        Info info = null;
        if(infoEntity != null) {
            info = new Info();
            info.setFirstname(infoEntity.getFirstname());
            info.setLastname(infoEntity.getLastname());
        }

        return info;
    }
}
