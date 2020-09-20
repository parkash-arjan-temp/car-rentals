package car.rentals.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import car.rentals.exception.CarNotAvaiableForRentException;
import car.rentals.exception.CarNotFoundException;
import car.rentals.exception.CustomerNotFoundException;
import car.rentals.model.vo.Car;
import car.rentals.model.vo.CarType;
import car.rentals.model.vo.Customer;

class ReservationServiceTest {
	ReservationService reservationService = null;
	Customer validCustomer = null;
	Customer inValidCustomer = null;
	Car validCar = null;
	Car invalidCar = null;

	@BeforeEach
	void init() {
		reservationService = new ReservationService();
		validCustomer = new Customer(203L, "Kevin", "508-ZZZ-ZZZZ");
		inValidCustomer = new Customer(000L, "Invalid Customer", "III-III-INLD");
		validCar = new Car(302L, "Sieana", new CarType(104L, "Minivan"), LocalDate.of(2019, Month.JANUARY, 01),
				"Toyota");

		invalidCar = new Car(000L, "INVALID", new CarType(000L, "INVALID"), LocalDate.of(2019, Month.JANUARY, 01),
				"INVALID");
	}

	@Test
	void reserveCarValidCase() {
		boolean isReserved = reservationService.reserve(validCustomer, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);
		assertTrue(isReserved, "This car should be reserved by the customer");
	}

	@Test
	void reserveCarOverlappingInvalidCase() {

		boolean isReserved = reservationService.reserve(validCustomer, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);
		assertTrue(isReserved, "This car has not been by reserved customer,so it can be reserved");

		assertThrows(CarNotAvaiableForRentException.class,
				() -> reservationService.reserve(validCustomer, validCar, LocalDate.of(2020, Month.SEPTEMBER, 25), 3),
				"This car has already been reserved by customer, reserve for differnt duration");

	}

	@Test
	void reserveWithInvalidCustomerTest() {
		assertThrows(CustomerNotFoundException.class, () -> reservationService.reserve(inValidCustomer, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3));
	}

	@Test
	void reserveWithInvalidCarTest() {
		assertThrows(CarNotFoundException.class, () -> reservationService.reserve(validCustomer, invalidCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3));
	}

}
