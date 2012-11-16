package me.victorhernandez.springhibernate.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import me.victorhernandez.springhibernate.model.Car;
import me.victorhernandez.springhibernate.service.CarService;
import me.victorhernandez.springhibernate.service.CarServiceImp;

@ManagedBean(name="carsMb")
@ViewScoped
public class CarBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8382801450376130765L;
	
	@ManagedProperty(value="#{carServiceImp}")
	private CarService service;
	private Car car;
	
	public CarService getService() {
		return service;
	}

	public void setService(CarService service) {
		this.service = service;
	}
	
	
	public CarBean(){
		car = new Car();
	}

	public List<Car> getCars() {
		if(service.getCars() == null)
			return new ArrayList<Car>();
		else
			return service.getCars();
	}
	
	public Car getCar() {
		return this.car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public void submit(){
		service.addCar(car);
		FacesMessage message = new FacesMessage("Registro exitoso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
