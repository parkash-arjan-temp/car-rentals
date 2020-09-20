package car.rentals.dao;

import java.util.List;

import car.rentals.model.vo.Car;
import car.rentals.model.vo.CarType;

public interface CarDao {
	
	public List<Car> getCars();
	public List<CarType> getCarTypes();
	public Car findCarById(Long carId);
	public Car findCar(Car car);
}
