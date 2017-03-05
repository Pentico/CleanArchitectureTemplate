package com.pencorp.data.entity;

/**
 * Created by Tuane on 5/03/17.
 */

import com.google.gson.annotations.SerializedName;

/**
 * Info Entity used in the data layer
 */
public class InfoEntity {

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
