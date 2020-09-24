package car.rentals.dao.local.impl;

import car.rentals.dao.CarDao;
import car.rentals.model.vo.Car;

public abstract class AbstractCarDao implements CarDao {
	public Car findCar(Car car) {
		return findCarById(car.getCarId());
	}

	public Car findCarById(Long carId) {
		return getCars().stream()
				.filter(car -> car.getCarId().longValue() == carId.longValue())
				.findAny()
				.orElse(null);
	}
}
