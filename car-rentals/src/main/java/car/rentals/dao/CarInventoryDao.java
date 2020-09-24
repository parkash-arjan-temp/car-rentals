package car.rentals.dao;

import java.util.List;

import car.rentals.model.vo.CarInventory;

public interface CarInventoryDao {
	public List<CarInventory> getCarInventory();
	public int getNumberOfAvaiableCars(Long carId);
	public void updateInventory(Long carId);
	public CarInventory findInventoryForCar(Long carId);
}
