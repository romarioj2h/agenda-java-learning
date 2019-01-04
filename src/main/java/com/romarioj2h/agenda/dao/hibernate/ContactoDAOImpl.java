package com.romarioj2h.agenda.dao.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.romarioj2h.agenda.dao.ContactoDAO;
import com.romarioj2h.agenda.models.Contacto;

@Repository("contactoDAO")
@Transactional
public class ContactoDAOImpl extends AbstractDAO implements ContactoDAO {

	@Override
	public boolean agregar(Contacto contacto) {
		Session session = this.getSession();
		session.save(contacto);
		return true;
	}

	@Override
	public List<Contacto> listado() {
		Session session = this.getSession();
		CriteriaQuery<Contacto> criteriaQuery = session.getCriteriaBuilder().createQuery(Contacto.class);
		criteriaQuery.from(Contacto.class);
		List<Contacto> contactos = session.createQuery(criteriaQuery).getResultList();
		return contactos;
	}

	@Override
	public boolean borrar(Contacto contacto) {
		Session session = this.getSession();
		session.beginTransaction();
		session.delete(contacto);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public Contacto obtener(Integer id) {
		Session session = this.getSession();
		return (Contacto) session.load(Contacto.class, id);
	}
}
