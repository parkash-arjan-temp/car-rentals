package car.rentals.service;

import java.time.LocalDate;
import java.util.List;

import car.rentals.dao.ReservationDao;
import car.rentals.dao.local.impl.LocalReservationDaoImpl;
import car.rentals.exception.CarNotAvaiableForRentException;
import car.rentals.exception.CarNotFoundException;
import car.rentals.exception.CustomerNotFoundException;
import car.rentals.exception.InvalidRentDurationException;
import car.rentals.model.vo.Car;
import car.rentals.model.vo.Customer;
import car.rentals.model.vo.Reservation;

public class ReservationService {

	private CustomerService customerService;
	private CarService carService;
	private CarInventoryService carInventoryService;

	private ReservationDao reservationDao;

	public ReservationService() {
		customerService = new CustomerService();
		carService = new CarService();
		carInventoryService = new CarInventoryService();
		reservationDao = new LocalReservationDaoImpl();
	}

	private boolean isValidCustomer(Customer customer) {
		return customerService.isValidCustomer(customer);
	}

	private boolean isValidCar(Car car) {
		return carService.isValidCar(car);
	}

	private boolean isValidRentDays(int numberOfDays) {
		return numberOfDays > 0;
	}

	private boolean isValidDate(LocalDate startDate) {
		return !(startDate == null || startDate.isBefore(LocalDate.now()));
	}

	// method either returns true or throw an appropriate exception.
	private boolean validateInput(Customer customer, Car car, LocalDate startDate, int numberOfDays) {

		if (!isValidCustomer(customer)) {
			throw new CustomerNotFoundException("Customer not registered in the system.");
		}
		if (!isValidCar(car)) {
			throw new CarNotFoundException("Car not found in the system.");
		}

		if (!isValidDate(startDate)) {
			throw new InvalidRentDurationException("Date is invalid for rent duration.");
		}

		if (!isValidRentDays(numberOfDays)) {
			throw new InvalidRentDurationException("Days requested for reservation are invalid.");
		}
		return true;
	}

	private boolean isCarAvaiableForCustomer(Long customerId, Long carId, LocalDate startDate) {

		List<Reservation> reservationsByCustomer = reservationDao.getReservationsByCustomer(customerId);

		for (Reservation reservation : reservationsByCustomer) {

			if (reservation.getCarId().longValue() == carId && !startDate.isAfter(reservation.getEndDate())) {
				return false;
			}
		}

		return true;
	}

	public boolean reserve(Customer customer, Car car, LocalDate startDate, int numberOfDays) {

		if (validateInput(customer, car, startDate, numberOfDays)) {

			if (!carInventoryService.isCarAvailable(car.getCarId())) {
				throw new CarNotAvaiableForRentException(
						"Car is not avaiable in the inventory. Try to reseve another car.");
			}

			if (!isCarAvaiableForCustomer(customer.getCustomerId(), car.getCarId(), startDate)) {
				throw new CarNotAvaiableForRentException(
						"Same customer can not reserve the same car for non-overlapping duration.Try another duration.");
			}

			reservationDao.addReservation(new Reservation(car.getCarId(), customer.getCustomerId(), startDate,
					startDate.plusDays(numberOfDays - 1L), numberOfDays));

			return true;
		}
		return false;
	}

	public List<Reservation> getReservations() {
		return reservationDao.getReservations();
	}
}
