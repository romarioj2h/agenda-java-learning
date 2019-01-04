package com.romarioj2h.agenda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.romarioj2h.agenda.models.Contacto;

public class ContactoDAOImpl {

	public Connection connection;
	
	public ContactoDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ContactoDAOImpl(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean agregar(Contacto contacto) {
		boolean resultado = false;
		String sql = "insert into contacto set nombre = ?, telefono = ?";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, contacto.getNombre());
			preparedStatement.setString(2, contacto.getTelefono());
			resultado = preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				contacto.setId(id);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al guardar registro");
		}
		return resultado;
	}
	
	public List<Contacto> listado() {
		String sql = "select id, nombre, telefono from contacto";
		List<Contacto> contactos = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			this.transformaResultSetEnContactos(preparedStatement.getResultSet(), contactos);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener listado de contactos");
		}
		
		return contactos;
	}
	
	private List<Contacto> transformaResultSetEnContactos(ResultSet resultSet, List<Contacto> contactos) throws SQLException {
		while (resultSet.next()) {
			Contacto contacto = new Contacto(
				resultSet.getInt("id"),
				resultSet.getString("nombre"),
				resultSet.getString("telefono")
			);
			contactos.add(contacto);
		}
		return contactos;
	}

	public boolean borrar(Contacto contacto) {
		boolean resultado = false;
		String sql = "delete from contacto where id = ?";
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setInt(1, contacto.getId());
			resultado = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al guardar registro");
		}
		return resultado;		
	}

	public Contacto obtener(Integer id) {
		String sql = "select id, nombre, telefono from contacto where id = ?";
		Contacto contacto = new Contacto();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			resultSet.first();
			contacto.setId(resultSet.getInt("id"));
			contacto.setNombre(resultSet.getString("nombre"));
			contacto.setTelefono(resultSet.getString("telefono"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener listado de contactos");
		}
		
		return contacto;
	}
}
