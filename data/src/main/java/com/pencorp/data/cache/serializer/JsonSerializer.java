package com.pencorp.data.cache.serializer;

import com.google.gson.Gson;
import com.pencorp.data.entity.InfoEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 5/03/17.
 */


/**
 * Class info as Serializer/Deserializer for info entities.
 */
@Singleton
public class JsonSerializer {

    private final Gson gson = new Gson();

    @Inject
    public JsonSerializer() {}

    /**
     * Serialize an object to Json.
     *
     * @param infoEntity {@link InfoEntity} to serialize.
     */
    public String serialize(InfoEntity infoEntity) {
        String jsonString = gson.toJson(infoEntity, InfoEntity.class);
        return jsonString;
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param jsonString A json string to deserialize.
     * @return {@link InfoEntity}
     */
    public InfoEntity deserialize(String jsonString) {
        InfoEntity infoEntity = gson.fromJson(jsonString, InfoEntity.class);
        return infoEntity;
    }
}
