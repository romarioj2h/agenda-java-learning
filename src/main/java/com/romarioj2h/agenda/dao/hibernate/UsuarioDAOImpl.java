package com.romarioj2h.agenda.dao.hibernate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.romarioj2h.agenda.dao.UsuarioDAO;
import com.romarioj2h.agenda.models.Usuario;

@Repository("UsuarioDAO")
@Transactional
public class UsuarioDAOImpl extends AbstractDAO implements UsuarioDAO {

	@Override
	public Usuario obtener(Integer id) {
		Session session = this.getSession();
		return (Usuario) session.load(Usuario.class, id);
	}

	@Override
	public Usuario obtenerPorUsuarioContrasena(String usuario, String contrasena) {
		Session session = this.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("usuario"), usuario));
		return session.createQuery(criteriaQuery).getSingleResult();
	}
}
