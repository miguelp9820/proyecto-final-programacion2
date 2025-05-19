package com.sakila.reports;

import com.sakila.models.Film;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilmReport {

    public static void exportToCSV(List<Film> films, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("film_id;title;description;release_year;last_update\n");

            for (Film film : films) {
                writer.append(film.getFilmId() + ";")
                      .append(film.getTitle() + ";")
                      .append(film.getDescription() + ";")
                      .append(film.getReleaseYear() + ";")
                      .append(film.getLastUpdate() + "\n");
            }

            System.out.println("📄 CSV de películas exportado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar CSV: " + e.getMessage());
        }
    }

    public static void exportToJSON(List<Film> films, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(films, writer);
            System.out.println("📄 JSON de películas exportado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }
}
