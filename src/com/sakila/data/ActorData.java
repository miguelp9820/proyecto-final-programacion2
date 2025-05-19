package com.sakila.data;

import com.sakila.models.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona operaciones CRUD para actores.
 * Hereda de DataContext y se conecta con la tabla actor en Sakila.
 */

public final class ActorData extends DataContext<Actor> {
	
	@Override
    public void save(Actor actor) 
	{
        String sql = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, NOW())";
        executeUpdate(sql, actor.getFirstName(), actor.getLastName());
    }
	
	@Override
	public void update(Actor actor)
	{
		 String sql = "UPDATE actor SET first_name = ?, last_name = ?, last_update = NOW() WHERE actor_id = ?";
	        executeUpdate(sql, actor.getFirstName(), actor.getLastName(), actor.getActorId());
	}
	
    @Override
    public void delete(int id) 
    {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        executeUpdate(sql, id);
    }

    @Override
    public Actor getById(int id) 
    {
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        ResultSet rs = executeQuery(sql, id);

        try 
        {
            if (rs != null && rs.next()) 
            {
                return mapResultSetToActor(rs);
            }
        } catch (SQLException e) 
        {
            System.out.println("❌ Error al obtener actor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Actor> getAll() 
    {
        String sql = "SELECT * FROM actor";
        ResultSet rs = executeQuery(sql);
        List<Actor> lista = new ArrayList<>();

        try 
        {
            while (rs != null && rs.next()) 
            {
                lista.add(mapResultSetToActor(rs));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener lista de actores: " + e.getMessage());
        }

        return lista;
    }

    // Método de utilidad para convertir ResultSet en objeto Actor
    private Actor mapResultSetToActor(ResultSet rs) throws SQLException 
    {
        int id = rs.getInt("actor_id");
        String first = rs.getString("first_name");
        String last = rs.getString("last_name");
        Timestamp time = rs.getTimestamp("last_update");
        return new Actor(id, first, last, time);
    }

}
