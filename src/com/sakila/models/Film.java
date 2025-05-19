package com.sakila.models;

import java.sql.Timestamp;
/**
 * Clase modelo que representa una película en la base de datos Sakila.
 * Contiene atributos como ID, título, descripción, año de estreno y última actualización.
 */

public class Film {
	
	 private int filmId;
	    private String title;
	    private String description;
	    private int releaseYear;
	    private Timestamp lastUpdate;

	    public Film() {}

	    public Film(String title, String description, int releaseYear) 
	    {
	        this.title = title;
	        this.description = description;
	        this.releaseYear = releaseYear;
	    }

	    public Film(int filmId, String title, String description, int releaseYear, Timestamp lastUpdate) 
	    {
	        this.filmId = filmId;
	        this.title = title;
	        this.description = description;
	        this.releaseYear = releaseYear;
	        this.lastUpdate = lastUpdate;
	    }

	    public int getFilmId() 
	    {
	        return filmId;
	    }

	    public void setFilmId(int filmId) 
	    {
	        this.filmId = filmId;
	    }

	    public String getTitle() 
	    {
	        return title;
	    }

	    public void setTitle(String title) 
	    {
	        this.title = title;
	    }

	    public String getDescription() 
	    {
	        return description;
	    }

	    public void setDescription(String description) 
	    {
	        this.description = description;
	    }

	    public int getReleaseYear() 
	    {
	        return releaseYear;
	    }

	    public void setReleaseYear(int releaseYear) 
	    {
	        this.releaseYear = releaseYear;
	    }

	    public Timestamp getLastUpdate() 
	    {
	        return lastUpdate;
	    }

	    public void setLastUpdate(Timestamp lastUpdate) 
	    {
	        this.lastUpdate = lastUpdate;
	    }

	    @Override
	    public String toString() 
	    {
	        return filmId + " - " + title + " (" + releaseYear + ")";
	    }

}
