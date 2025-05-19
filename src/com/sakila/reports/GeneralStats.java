package com.sakila.reports;

import com.sakila.models.Actor;
import com.sakila.models.City;
import com.sakila.models.Film;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralStats {

    public static void mostrarEstadisticasActores(List<Actor> actores) {
        System.out.println("\n📊 ESTADISTICAS DE ACTORES 📊");

        // Total
        System.out.println("👥 Total de actores: " + actores.size());

        // Iniciales del apellido
        Map<Character, Integer> iniciales = new HashMap<>();
        for (Actor actor : actores) {
            if (actor.getLastName() != null && !actor.getLastName().isEmpty()) {
                char inicial = Character.toUpperCase(actor.getLastName().charAt(0));
                iniciales.put(inicial, iniciales.getOrDefault(inicial, 0) + 1);
            }
        }

        System.out.println("🔤 Actores por inicial del apellido:");
        for (Map.Entry<Character, Integer> entry : iniciales.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void mostrarEstadisticasPeliculas(List<Film> peliculas) {
        System.out.println("\n🎬 ESTADISTICAS DE PELICULAS 🎬");

        // Total
        System.out.println("🎞️ Total de peliculas: " + peliculas.size());

        // Películas por año de estreno
        Map<Integer, Integer> peliculasPorAnio = new HashMap<>();
        for (Film film : peliculas) {
            int anio = film.getReleaseYear();
            peliculasPorAnio.put(anio, peliculasPorAnio.getOrDefault(anio, 0) + 1);
        }

        System.out.println("📅 Peliculas por año de estreno:");
        for (Map.Entry<Integer, Integer> entry : peliculasPorAnio.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }

        // Película con título más largo
        Film tituloMasLargo = null;
        for (Film film : peliculas) {
            if (tituloMasLargo == null || film.getTitle().length() > tituloMasLargo.getTitle().length()) {
                tituloMasLargo = film;
            }
        }

        if (tituloMasLargo != null) {
            System.out.println("🏆 Pelicula con el título mas largo: " + tituloMasLargo.getTitle()
                + " (" + tituloMasLargo.getTitle().length() + " caracteres)");
        }
    }
    
    public static void mostrarEstadisticasCiudades(List<City> ciudades) {
        System.out.println("\n🏙️ ESTADISTICAS DE CIUDADES 🏙️");

        // Total
        System.out.println("🌍 Total de ciudades: " + ciudades.size());

        // Ciudades por country_id
        Map<Integer, Integer> porPais = new HashMap<>();
        for (City city : ciudades) {
            int countryId = city.getCountryId();
            porPais.put(countryId, porPais.getOrDefault(countryId, 0) + 1);
        }

        System.out.println("🗺️ Ciudades por pais (country_id):");
        for (Map.Entry<Integer, Integer> entry : porPais.entrySet()) {
            System.out.println("  Pais ID " + entry.getKey() + ": " + entry.getValue() + " ciudades");
        }
    }


}
