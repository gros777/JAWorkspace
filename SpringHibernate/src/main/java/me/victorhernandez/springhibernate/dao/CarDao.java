package me.victorhernandez.springhibernate.dao;

import java.util.List;

import me.victorhernandez.springhibernate.model.Car;

public interface CarDao {
	
	
	public void addCar(Car car);
	
	public List<Car> getAll();
}
