package com.sakila.data;

import com.sakila.models.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona operaciones CRUD para ciudades.
 * Se conecta a la tabla city y realiza acciones de inserción, consulta, modificación y eliminación.
 */

public final class CityData extends DataContext<City> {

    @Override
    public void save(City city) 
    {
        String sql = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, NOW())";
        executeUpdate(sql, city.getCity(), city.getCountryId());
    }

    @Override
    public void update(City city) 
    {
        String sql = "UPDATE city SET city = ?, country_id = ?, last_update = NOW() WHERE city_id = ?";
        executeUpdate(sql, city.getCity(), city.getCountryId(), city.getCityId());
    }

    @Override
    public void delete(int id) 
    {
        String sql = "DELETE FROM city WHERE city_id = ?";
        executeUpdate(sql, id);
    }

    @Override
    public City getById(int id) 
    {
        String sql = "SELECT * FROM city WHERE city_id = ?";
        ResultSet rs = executeQuery(sql, id);

        try 
        {
            if (rs != null && rs.next()) 
            {
                return mapResultSetToCity(rs);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener ciudad: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<City> getAll() 
    {
        String sql = "SELECT * FROM city";
        ResultSet rs = executeQuery(sql);
        List<City> lista = new ArrayList<>();

        try 
        {
            while (rs != null && rs.next()) 
            {
                lista.add(mapResultSetToCity(rs));
            }
        } catch (SQLException e) {
        	System.out.println("❌ Error al obtener ciudades: " + e.getMessage());
        }
        return lista;
        
    }
    
    private City mapResultSetToCity(ResultSet rs) throws SQLException
    {
    	int id =rs.getInt("city_id");
        String name = rs.getString("city");
        int countryId = rs.getInt("country_id");
        Timestamp last = rs.getTimestamp("last_update");
        
        return new City(id, name, countryId, last);
    }
}
