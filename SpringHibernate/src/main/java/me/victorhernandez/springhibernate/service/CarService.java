package me.victorhernandez.springhibernate.service;

import java.util.List;

import me.victorhernandez.springhibernate.model.Car;

public interface CarService {
	
	public void addCar(Car car);
	public List<Car> getCars();
}
