package com.romarioj2h.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO {

	public Connection connection;

	public ResultSet obtener(PreparedStatement preparedStatement) throws BaseDatosExcepcion {
		try {
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			resultSet.first();
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BaseDatosExcepcion("Error al obtener listado de contactos");
		}
	}

	public ResultSet obtenerPorID(String sql, Integer id) throws BaseDatosExcepcion {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return this.obtener(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BaseDatosExcepcion("Error al obtener listado de contactos");
		}
	}
}
