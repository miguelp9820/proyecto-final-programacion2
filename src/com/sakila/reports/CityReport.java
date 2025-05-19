package com.sakila.reports;

import com.sakila.models.City;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CityReport {

    public static void exportToCSV(List<City> cities, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("city_id;city;country_id;last_update\n");

            for (City city : cities) {
                writer.append(city.getCityId() + ";")
                      .append(city.getCity() + ";")
                      .append(city.getCountryId() + ";")
                      .append(city.getLastUpdate() + "\n");
            }

            System.out.println("📄 CSV de ciudades exportado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar CSV: " + e.getMessage());
        }
    }

    public static void exportToJSON(List<City> cities, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(cities, writer);
            System.out.println("📄 JSON de ciudades exportado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }
}
