package com.romarioj2h.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.romarioj2h.agenda.models.Usuario;

@Component
public class UsuarioDAO extends AbstractDAO {

	public Connection connection;
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario obtener(Integer id) throws BaseDatosExcepcion {
		String sql = "select id, usuario, contrasena from usuario where id = ?";
		ResultSet resultSet = this.obtenerPorID(sql, id);
		return resultSetAUsuario(resultSet);
	}
	
	public Usuario obtenerPorUsuarioContrasena(String usuario, String contrasena) throws BaseDatosExcepcion {
		String sql = "select id, usuario, contrasena from usuario where usuario = ? and contrasena = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, contrasena);
			ResultSet resultSet = obtener(preparedStatement);
			if (!resultSet.first()) {
				return null;
			}
			return resultSetAUsuario(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BaseDatosExcepcion("Error al obtener datos del usuario");
		}
	}
	
	private Usuario resultSetAUsuario(ResultSet resultSet) throws BaseDatosExcepcion {
		Usuario usuario = new Usuario();
		try {
			usuario.setId(resultSet.getInt("id"));
			usuario.setUsuario(resultSet.getString("usuario"));
			usuario.setContrasena(resultSet.getString("contrasena"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BaseDatosExcepcion("Error al obtener datos del usuario");
		}
		return usuario;
	}
}
