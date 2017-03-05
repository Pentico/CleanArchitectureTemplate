package com.pencorp.cleanarchitecture.model;

/**
 * Created by Tuane on 5/03/17.
 */

/**
 * Class that represents a info in the presentation layer.
 */
public class InfoModel {

    public InfoModel(){}

    private String firstname;
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
