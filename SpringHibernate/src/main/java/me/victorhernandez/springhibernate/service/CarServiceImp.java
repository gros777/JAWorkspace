package me.victorhernandez.springhibernate.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.springhibernate.dao.CarDao;
import me.victorhernandez.springhibernate.dao.CarDaoImp;
import me.victorhernandez.springhibernate.model.Car;

@Service
public class CarServiceImp implements CarService {
	
	@Resource(name="CarDaoRepository")
	private CarDao carDao;

	public CarDao getCarDao() {
		return carDao;
	}
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,
            propagation=Propagation.REQUIRED,
            rollbackFor=Exception.class)
	public void addCar(Car car){
		getCarDao().addCar(car);
	}
	@Override
	public List<Car> getCars(){
		return getCarDao().getAll();
	}
	
}
