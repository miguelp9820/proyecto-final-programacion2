package com.sakila.data;

import com.sakila.models.Film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona operaciones CRUD para películas.
 * Hereda de DataContext y trabaja con la tabla film en la base Sakila.
 */

public final class FilmData extends DataContext<Film> {
	
    @Override
    public void save(Film film) {
        String sql = "INSERT INTO film (title, description, release_year, last_update) VALUES (?, ?, ?, NOW())";
        executeUpdate(sql, film.getTitle(), film.getDescription(), film.getReleaseYear());
    }

    @Override
    public void update(Film film) {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, last_update = NOW() WHERE film_id = ?";
        executeUpdate(sql, film.getTitle(), film.getDescription(), film.getReleaseYear(), film.getFilmId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM film WHERE film_id = ?";
        executeUpdate(sql, id);
    }

    @Override
    public Film getById(int id) {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        ResultSet rs = executeQuery(sql, id);

        try {
            if (rs != null && rs.next()) {
                return mapResultSetToFilm(rs);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener película: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Film> getAll() {
        String sql = "SELECT * FROM film LIMIT 50";
        ResultSet rs = executeQuery(sql);
        List<Film> lista = new ArrayList<>();

        try {
            while (rs != null && rs.next()) {
                lista.add(mapResultSetToFilm(rs));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener lista de películas: " + e.getMessage());
        }

        return lista;
    }

    private Film mapResultSetToFilm(ResultSet rs) throws SQLException {
        int id = rs.getInt("film_id");
        String title = rs.getString("title");
        String desc = rs.getString("description");
        int year = rs.getInt("release_year");
        Timestamp last = rs.getTimestamp("last_update");

        return new Film(id, title, desc, year, last);
    }

}
