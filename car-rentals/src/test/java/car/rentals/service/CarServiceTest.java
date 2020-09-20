package car.rentals.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import car.rentals.model.vo.Car;
import car.rentals.model.vo.CarType;

class CarServiceTest {

	CarService carService;
	Car validCar;
	Car invalidCar;
	CarType carType;

	@BeforeEach
	void init() {

		carService = new CarService();

		validCar = new Car(301L, "Accord", new CarType(101L, "Sedan"), LocalDate.of(2012, Month.JANUARY, 01), "Honda");

		invalidCar = new Car(000L, "INVALID", new CarType(000L, "INVALID"), LocalDate.of(2012, Month.JANUARY, 01),
				"INVALID");
		carType = new CarType(101L, "Sedan");
	}

	@Test
	void getCarTest() {
		Car car = carService.getCar(validCar);
		assertNotNull(car, "Car with id 301 exist , it shoud not be null.");
		assertEquals("Accord", car.getName(), "Car name should be Accord.");
		assertEquals(carType, car.getType(), "Car Type should be Seda with an id of 101");
		assertEquals(LocalDate.of(2012, Month.JANUARY, 01), car.getMake(), "Car make should be January 01 ,2012.");
		assertEquals("Honda", car.getModel(), "Car model should be Honda.");

		car = carService.getCar(invalidCar);
		assertNull(car, "This car does not exist.");
	}

	@Test
	void getCarByIdTest() {
		Car car = carService.getCar(301L);
		assertNotNull(car, "Car with id 301 exist , it shoud not be null.");
		assertEquals("Accord", car.getName(), "Car name should be Accord.");
		assertEquals(carType, car.getType(), "Car Type should be Seda with an id of 101");
		assertEquals(LocalDate.of(2012, Month.JANUARY, 01), car.getMake(), "Car make should be January 01 ,2012.");
		assertEquals("Honda", car.getModel(), "Car model should be Honda.");

		car = carService.getCar(000L);
		assertNull(car, "This car does not exist.");
	}

	@Test
	void isValidCarByIdTest() {
		boolean isValidCar = carService.isValidCar(301L);
		assertTrue(isValidCar, "This is valid  car id and should return true.");

		isValidCar = carService.isValidCar(0000L);
		assertFalse(isValidCar, "This is invalid valid car id and should return false.");
	}

	@Test
	void isValidCarByReferenceTest() {
		boolean isValidCar = carService.isValidCar(validCar);
		assertTrue(isValidCar, "This is valid  car id and should return true.");

		isValidCar = carService.isValidCar(invalidCar);
		assertFalse(isValidCar, "This is invalid  car id and should return false.");
	}
}
