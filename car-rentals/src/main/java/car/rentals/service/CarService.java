package car.rentals.service;

import java.util.List;

import car.rentals.dao.CarDao;
import car.rentals.dao.local.impl.LocalCarDaoImpl;
import car.rentals.model.vo.Car;
import car.rentals.model.vo.CarType;

public class CarService {
	private CarDao carDao;

	public CarService() {
		carDao = new LocalCarDaoImpl();
	}

	public boolean isValidCar(Long carId) {
		return carDao.findCarById(carId) != null;
	}

	public boolean isValidCar(Car car) {
		return car.equals(carDao.findCarById(car.getCarId()));
	}

	public Car getCar(Long carId) {
		return carDao.findCarById(carId);
	}

	public Car getCar(Car car) {
		return carDao.findCarById(car.getCarId());
	}

	public List<Car> getCars() {
		return carDao.getCars();
	}

	public List<CarType> getCarTypes() {
		return carDao.getCarTypes();
	}
}
