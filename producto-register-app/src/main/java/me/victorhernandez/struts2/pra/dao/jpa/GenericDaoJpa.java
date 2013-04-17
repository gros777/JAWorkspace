package me.victorhernandez.struts2.pra.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.victorhernandez.struts2.pra.dao.GenericDao;
import me.victorhernandez.struts2.pra.domain.DomainObject;
import me.victorhernandez.struts2.pra.domain.Product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDaoJpa<T extends DomainObject> implements GenericDao<T> {

	private Class<T> type;

	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * Constructor receives a Class Type
	 * 
	 * @param type
	 */
	public GenericDaoJpa(Class<T> type) {
		super();
		this.type = type;
	}

	@Transactional(readOnly = true)
	public T get(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T)sessionFactory.getCurrentSession().get(type, id);
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createQuery(
				"select o from " + type.getName() + " o").list();
	}

	public void save(T object) {
		sessionFactory.getCurrentSession().save(object);

	}

	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}

}
