package com.sakila;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.sakila.data.ActorData;
import com.sakila.data.CityData;
import com.sakila.data.FilmData;
import com.sakila.models.Actor;
import com.sakila.models.City;
import com.sakila.models.Film;
import com.sakila.reports.ActorReport;
import com.sakila.reports.GeneralStats;
import com.sakila.utils.Validador;

/**
 * Clase principal del programa.
 * Muestra menús por consola para gestionar actores, películas y ciudades.
 * Incluye exportación de datos y estadísticas básicas.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestion de Actores");
            System.out.println("2. Gestion de Peliculas");
            System.out.println("3. Gestion de ciudades");
            System.out.println("4. Ver estadisticas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuActores(scanner);
                    break;
                case 2:
                    menuPeliculas(scanner);
                    break;
                case 3:
                	menuCiudades(scanner);
                	break;
                case 4:
                    int opcionStats;
                    do {
                        System.out.println("\n📊 MENÚ DE ESTADISTICAS 📊");
                        System.out.println("1. Actores");
                        System.out.println("2. Peliculas");
                        System.out.println("3. Ciudades");
                        System.out.println("0. Volver");
                        System.out.print("Selecciona una opcion: ");
                        opcionStats = scanner.nextInt();

                        switch (opcionStats) {
                            case 1:
                                GeneralStats.mostrarEstadisticasActores(new ActorData().getAll());
                                break;
                            case 2:
                                GeneralStats.mostrarEstadisticasPeliculas(new FilmData().getAll());
                                break;
                            case 3:
                                GeneralStats.mostrarEstadisticasCiudades(new CityData().getAll());
                                break;
                            case 0:
                                System.out.println("Volviendo...");
                                break;
                            default:
                                System.out.println("Opcion invalida.");
                        }
                    } while (opcionStats != 0);
                    break;


                case 0:
                    System.out.println("👋 Saliendo del programa.");
                    break;
                default:
                    System.out.println("❌ Opcion no valida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // MENU DE ACTORES
    public static void menuActores(Scanner scanner) {
        ActorData actorData = new ActorData();
        int opcion;

        do {
            System.out.println("\n--- GESTION DE ACTORES ---");
            System.out.println("1. Ver todos los actores");
            System.out.println("2. Buscar actor por ID");
            System.out.println("3. Insertar nuevo actor");
            System.out.println("4. Actualizar actor");
            System.out.println("5. Eliminar actor");
            System.out.println("6. Exportar actores a CSV y JSON");
            System.out.println("0. Volver al menu principal");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    List<Actor> lista = actorData.getAll();
                    lista.forEach(System.out::println);
                    break;
                case 2:
                	int idBuscar = Validador.leerEnteroPositivo(scanner, "ID del actor: ");
                    Actor actor = actorData.getById(idBuscar);
                    System.out.println(actor != null ? actor : "No encontrado.");
                    break;
                case 3:
                	String nombre = Validador.leerTextoObligatorio(scanner, "Nombre: ");
                	String apellido = Validador.leerTextoObligatorio(scanner, "Apellido: ");
                    actorData.save(new Actor(nombre, apellido));
                    System.out.println("✔️ Actor insertado.");
                    break;
                case 4:
                	int idUpdate = Validador.leerEnteroPositivo(scanner, "ID del actor a actualizar: ");
                    scanner.nextLine();
                    String newName = Validador.leerTextoObligatorio(scanner, "Nuevo nombre: ");
                    String newLast = Validador.leerTextoObligatorio(scanner, "Nuevo apellido: ");
                    Actor actualizado = new Actor(idUpdate, newName, newLast, new Timestamp(System.currentTimeMillis()));
                    actorData.update(actualizado);
                    System.out.println("✏️ Actor actualizado.");
                    break;
                case 5:
                    System.out.print("ID del actor a eliminar: ");
                    int idDelete = scanner.nextInt();
                    actorData.delete(idDelete);
                    System.out.println("🗑️ Actor eliminado.");
                    break;
                case 6:
                    List<Actor> actores = actorData.getAll();
                    ActorReport.exportToCSV(actores, "actores.csv");
                    ActorReport.exportToJSON(actores, "actores.json");
                    break;

                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("❌ Opcion no valida.");
            }

        } while (opcion != 0);
    }

    // MENU DE PELÍCULAS
    public static void menuPeliculas(Scanner scanner) {
        FilmData filmData = new FilmData();
        int opcion;

        do {
            System.out.println("\n--- GESTION DE PELICULAS ---");
            System.out.println("1. Ver todas las peliculas");
            System.out.println("2. Buscar pelicula por ID");
            System.out.println("3. Insertar nueva pelicula");
            System.out.println("4. Actualizar pelicula");
            System.out.println("5. Eliminar pelicula");
            System.out.println("6. Exportar peliculas a CSV y JSON");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    List<Film> peliculas = filmData.getAll();
                    peliculas.forEach(System.out::println);
                    break;
                case 2:
                	int idBuscar = Validador.leerEnteroPositivo(scanner, "ID de la película: ");
                    Film film = filmData.getById(idBuscar);
                    System.out.println(film != null ? film : "No encontrada.");
                    break;
                case 3:
                	String titulo = Validador.leerTextoObligatorio(scanner, "Título: ");
                	String descripcion = Validador.leerTextoObligatorio(scanner, "Descripción: ");
                	int anio = Validador.leerEnteroPositivo(scanner, "Año de estreno: ");
                    filmData.save(new Film(titulo, descripcion, anio));
                    System.out.println("✔️ Pelicula insertada.");
                    break;
                case 4:
                	int idActualizar = Validador.leerEnteroPositivo(scanner, "ID de la película a actualizar: ");
                    scanner.nextLine();
                    String nuevoTitulo = Validador.leerTextoObligatorio(scanner, "Nuevo título: ");
                    String nuevaDesc = Validador.leerTextoObligatorio(scanner, "Nueva descripción: ");
                    int nuevoAnio = Validador.leerEnteroPositivo(scanner, "Nuevo año de estreno: ");
                    Film actualizada = new Film(idActualizar, nuevoTitulo, nuevaDesc, nuevoAnio, new Timestamp(System.currentTimeMillis()));
                    filmData.update(actualizada);
                    System.out.println("✏️ Pelicula actualizada.");
                    break;
                case 5:
                	int idEliminar = Validador.leerEnteroPositivo(scanner, "ID de la película a eliminar: ");
                    filmData.delete(idEliminar);
                    System.out.println("🗑️ Pelicula eliminada.");
                    break;
                case 6:
                    List<Film> todas = filmData.getAll();
                    com.sakila.reports.FilmReport.exportToCSV(todas, "peliculas.csv");
                    com.sakila.reports.FilmReport.exportToJSON(todas, "peliculas.json");
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("❌ Opcion no valida.");
            }

        } while (opcion != 0);
    }
    // MENU CITY
    public static void menuCiudades(Scanner scanner) {
        CityData cityData = new CityData();
        int opcion;

        do {
            System.out.println("\n--- GESTION DE CIUDADES ---");
            System.out.println("1. Ver todas las ciudades");
            System.out.println("2. Buscar ciudad por ID");
            System.out.println("3. Insertar nueva ciudad");
            System.out.println("4. Actualizar ciudad");
            System.out.println("5. Eliminar ciudad");
            System.out.println("6. Exportar ciudades a CSV y JSON");
            System.out.println("0. Volver al menu principal");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    List<City> ciudades = cityData.getAll();
                    ciudades.forEach(System.out::println);
                    break;

                case 2:
                	int idBuscar = Validador.leerEnteroPositivo(scanner, "ID de la ciudad: ");
                    City ciudad = cityData.getById(idBuscar);
                    System.out.println(ciudad != null ? ciudad : "No encontrada.");
                    break;

                case 3:
                	String nombre = Validador.leerTextoObligatorio(scanner, "Nombre de la ciudad: ");
                	int countryId = Validador.leerEnteroPositivo(scanner, "ID del país (country_id): ");
                    cityData.save(new City(nombre, countryId));
                    System.out.println("✔️ Ciudad insertada.");
                    break;

                case 4:
                	int idActualizar = Validador.leerEnteroPositivo(scanner, "ID de la ciudad a actualizar: ");
                    scanner.nextLine();
                    String nuevoNombre = Validador.leerTextoObligatorio(scanner, "Nuevo nombre de ciudad: ");
                    int nuevoCountryId = Validador.leerEnteroPositivo(scanner, "Nuevo ID de país: ");
                    City ciudadActualizada = new City(idActualizar, nuevoNombre, nuevoCountryId, new Timestamp(System.currentTimeMillis()));
                    cityData.update(ciudadActualizada);
                    System.out.println("✏️ Ciudad actualizada.");
                    break;

                case 5:
                	int idEliminar = Validador.leerEnteroPositivo(scanner, "ID de la ciudad a eliminar: ");
                    cityData.delete(idEliminar);
                    System.out.println("🗑️ Ciudad eliminada.");
                    break;
                    
                case 6:
                    List<City> lista = cityData.getAll();
                    com.sakila.reports.CityReport.exportToCSV(lista, "ciudades.csv");
                    com.sakila.reports.CityReport.exportToJSON(lista, "ciudades.json");
                    break;


                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("❌ Opción no valida.");
            }

        } while (opcion != 0);
    }

}
