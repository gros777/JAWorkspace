package me.victorhernandez.springhibernate.test;

import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;

import me.victorhernandez.springhibernate.dao.CarDao;
import me.victorhernandez.springhibernate.dao.CarDaoImp;
import me.victorhernandez.springhibernate.model.Car;
import me.victorhernandez.springhibernate.service.CarService;
import me.victorhernandez.springhibernate.service.CarServiceImp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="/testApplicationContext.xml")
public class CarTest {

//	@Autowired
//	private CarDao carDaoTest;
//	@Autowired
//	private CarService carServiceTest;
//	
//	public CarService getCarServiceTest() {
//		return carServiceTest;
//	}
//
//	public void setCarServiceTest(CarService carServiceTest) {
//		this.carServiceTest = carServiceTest;
//	}
//
//	public CarDao getCarDaoTest() {
//		return carDaoTest;
//	}
//
//	public void setCarDaoTest(CarDao carDao) {
//		this.carDaoTest = carDao;
//	}
//
//	private Logger logger = Logger.getLogger("SpringHibernateLog");
//	private Long id;
//	
//	@Test
//	public void listCarsTest(){
//		List<Car> cars = carDaoTest.getAll();
//		for (Car car : cars){
//			logger.info("Car Id:" + car.getId() + " Name: " + car.getCarName());
//		}
//		Assert.assertNotNull(cars);
//		Assert.assertEquals(4, cars.size());
//	}
	
//	@Test
//	public void listCarsService(){
//		List<Car> cars = carServiceTest.getCars();
//		Assert.assertNotNull(cars);
//		int carInitNum = cars.size();
//		Car aNewCar = new Car();
//		aNewCar.setCarName("Its a new car Test");
//		aNewCar.setId(null);
//		carServiceTest.addCar(aNewCar);
//		cars = carServiceTest.getCars();
//		Assert.assertEquals(carInitNum+1, cars.size());
//	}
	
}
