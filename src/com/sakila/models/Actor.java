package com.sakila.models;

import java.sql.Timestamp;
/**
 * Clase modelo que representa un actor de la base de datos Sakila.
 * Contiene atributos como ID, nombre, apellido y la última fecha de modificación.
 */

public class Actor {
	
    private int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
    
    public Actor() {}
    
    public Actor(int actorid, String firstName, String lastName, Timestamp lastUpdate)
    {
    	this.actorId = actorid;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.lastUpdate = lastUpdate;
    }
    
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters y Setters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return actorId + ": " + firstName + " " + lastName;
    }

}
