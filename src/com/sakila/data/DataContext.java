package com.sakila.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sakila.utils.DBConnection;

public abstract class DataContext<T> implements iDatapost<T>{
	
	protected final Connection connection;
	
	public DataContext()
	{
		this.connection = DBConnection.getConnection();
	}
	
	protected final boolean executeUpdate(String sql, Object... params)
	{
		try (PreparedStatement stmt = connection.prepareStatement(sql))
		{
			setParameters(stmt, params);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("❌ error executeUpdate" + e.getMessage());
			return false;
		}
	}
	
	protected final ResultSet executeQuery(String sql, Object... params)
	{
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			setParameters(stmt, params);
			return stmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("❌ Error en executeQuery: " + e.getMessage());
            return null;
		}
	}
	
    private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) 
        {
            stmt.setObject(i + 1, params[i]);
        }
    }

}
