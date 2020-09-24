package car.rentals.dao.local.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import car.rentals.model.vo.Car;
import car.rentals.model.vo.CarType;

public class LocalCarDaoImpl extends AbstractCarDao {

	public List<Car> getCars() {

		return Arrays.asList(
				new Car(301L, "Accord", new CarType(101L, "Sedan"), LocalDate.of(2012, Month.JANUARY, 01), "Honda"),
				new Car(302L, "Sieana", new CarType(104L, "Minivan"), LocalDate.of(2019, Month.JANUARY, 01), "Toyota"),
				new Car(303L, "Civic SI", new CarType(102L, "Coupe"), LocalDate.of(2013, Month.JANUARY, 01), "BMW"),
				new Car(304L, "Prius", new CarType(103L, "Hatchback"), LocalDate.of(2020, Month.JANUARY, 01),
						"Toyota"));

	}

	public List<CarType> getCarTypes() {
		return Arrays.asList(new CarType(101L, "Sedan"), 
				new CarType(102L, "Coupe"), 
				new CarType(103L, "Hatchback"),
				new CarType(104L, "Minivan"));
	}

}
