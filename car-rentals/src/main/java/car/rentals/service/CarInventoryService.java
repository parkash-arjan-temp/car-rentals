package car.rentals.service;

import java.util.List;

import car.rentals.dao.CarInventoryDao;
import car.rentals.dao.local.impl.LocalCarInventoryDaoImpl;
import car.rentals.model.vo.CarInventory;

public class CarInventoryService {
	private CarInventoryDao carInventoryDao = new LocalCarInventoryDaoImpl();

	public List<CarInventory> getInventory() {
		return carInventoryDao.getCarInventory();
	}

	public boolean isCarAvailable(Long carId) {
		return carInventoryDao.findInventoryForCar(carId).getAvailable() > 0;
	}

	public void updateInventory(Long carId) {
		carInventoryDao.updateInventory(carId);
	}

	public CarInventory findInventoryForCar(Long carId) {
		return carInventoryDao.findInventoryForCar(carId);
	}
}
