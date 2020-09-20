package car.rentals.dao.local.impl;

import java.util.stream.Collectors;

import car.rentals.dao.CarInventoryDao;

public abstract class AbstractCarInventoryDao implements CarInventoryDao {
	public int getNumberOfAvaiableCars(Long carId) {
		return getCarInventory().stream().filter(car -> car.getCarId().longValue() == carId.longValue())
				.collect(Collectors.toList()).size();

	}
}
