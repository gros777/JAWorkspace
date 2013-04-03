package me.victorhernandez.struts2.pra.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.victorhernandez.struts2.pra.dao.GenericDao;
import me.victorhernandez.struts2.pra.domain.DomainObject;
import me.victorhernandez.struts2.pra.domain.Product;

import org.springframework.transaction.annotation.Transactional;

public class GenericDaoJpa<T extends DomainObject> implements GenericDao<T> {

	private Class<T> type;
	protected EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
			return entityManager.find(type, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> getAll() {
		return entityManager.createQuery(
				"select o from " + type.getName() + " o").getResultList();
	}

	public void save(T object) {
		entityManager.persist(object);

	}

	public void delete(T object) {
		entityManager.remove(object);
	}

}
