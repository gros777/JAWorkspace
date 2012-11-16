package me.victorhernandez.springhibernate.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import me.victorhernandez.springhibernate.model.Car;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("CarDaoRepository")
public class CarDaoImp implements CarDao {
	
	
	private EntityManager entityManager;

	@PersistenceContext(unitName="testsource")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void addCar(Car car) {

		this.entityManager.persist(car);

	}
	
	@SuppressWarnings("unchecked")
	public List<Car> getAll(){
		
		return this.entityManager.createQuery("from Car").getResultList();
		
	}
}
