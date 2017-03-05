package com.pencorp.data.entity.mapper;

/**
 * Created by Tuane on 5/03/17.
 */

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pencorp.data.entity.InfoEntity;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class InfoEntityJsonMapper {

    private final Gson gson;

    @Inject
    public InfoEntityJsonMapper() {
        this.gson = new Gson();
    }

    /**
     * Transform from valid json string to {@link InfoEntity}.
     *
     * @param infoJsonResponse A json representing a info.
     * @return {@link InfoEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public InfoEntity transformUserEntity(String infoJsonResponse) throws JsonSyntaxException {
        try {
            Type infoEntityType = new TypeToken<InfoEntity>() {}.getType();
            InfoEntity infoEntity = this.gson.fromJson(infoJsonResponse, infoEntityType);

            return infoEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
