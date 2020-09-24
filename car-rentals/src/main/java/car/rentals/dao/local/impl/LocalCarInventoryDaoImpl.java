package car.rentals.dao.local.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import car.rentals.exception.CarNotFoundException;
import car.rentals.model.vo.CarInventory;

public class LocalCarInventoryDaoImpl extends AbstractCarInventoryDao {

	private List<CarInventory> carInventory;

	public LocalCarInventoryDaoImpl() {
		carInventory = new ArrayList<>(
				Arrays.asList(new CarInventory(401L, 301L, 20, 2, 22), 
						new CarInventory(402L, 302L, 15, 2, 17),
						new CarInventory(403L, 303L, 5, 0, 5), 
						new CarInventory(404L, 304L, 1, 0, 1)));
	}

	public List<CarInventory> getCarInventory() {
		return carInventory;
	}

	public CarInventory findInventoryForCar(Long carId) {
		return getCarInventory()
				.stream().filter(carInvtry -> carInvtry.getCarId().longValue() == carId.longValue())
				.findAny()
				.orElse(null);
	}

	public void updateInventory(Long carId) {

		CarInventory inventory = getCarInventory()
				.stream()
				.filter(carInvtry -> carInvtry.getCarId().longValue() == carId.longValue())
				.findAny()
				.orElse(null);

		if (inventory != null) {
			updateInventoryValues(inventory);
		} else {
			throw new CarNotFoundException("Car id not found in the system.");
		}
	}

	private void updateInventoryValues(CarInventory inventory) {
		inventory.setRented(inventory.getRented() + 1);
		inventory.setAvailable(inventory.getAvailable() - 1);
	}

}
