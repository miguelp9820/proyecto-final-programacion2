package com.sakila.models;

import java.sql.Timestamp;
/**
 * Clase modelo que representa una ciudad en la base de datos Sakila.
 * Contiene atributos como ID, nombre de la ciudad, ID del país y última fecha de modificación.
 */

public class City {
    private int cityId;
    private String city;
    private int countryId;
    private Timestamp lastUpdate;

    public City() {}

    public City(String city, int countryId) {
        this.city = city;
        this.countryId = countryId;
    }

    public City(int cityId, String city, int countryId, Timestamp lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return cityId + " - " + city + " (Pais ID: " + countryId + ")";
    }
}
