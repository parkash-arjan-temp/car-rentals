package car.rentals.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
	CarInventoryService carInventoryService = null;
	Customer validCustomerKevin = null;
	Customer validCustomerJohn = null;
	Customer inValidCustomer = null;
	Car validCar = null;
	Car invalidCar = null;
	Car validCarQuantityOne = null; // TODO: re-factor the name of variable.
	ServiceContainer serviceFactory;

	@BeforeEach
	void init() {
		serviceFactory = ServiceContainer.getInstance();
		reservationService = serviceFactory.getReservationService();
		carInventoryService = serviceFactory.getCarInventoryService();

		validCustomerKevin = new Customer(203L, "Kevin", "508-ZZZ-ZZZZ");
		validCustomerJohn = new Customer(201L, "John", "508-XXX-XXXX");

		inValidCustomer = new Customer(000L, "Invalid Customer", "III-III-INLD");
		validCar = new Car(302L, "Sieana", new CarType(104L, "Minivan"), LocalDate.of(2019, Month.JANUARY, 01),
				"Toyota");

		invalidCar = new Car(000L, "INVALID", new CarType(000L, "INVALID"), LocalDate.of(2019, Month.JANUARY, 01),
				"INVALID");

		// only one car is available for this type/model
		validCarQuantityOne = new Car(304L, "Prius", new CarType(103L, "Hatchback"),
				LocalDate.of(2020, Month.JANUARY, 01), "Toyota");

	}

	@Test
	void reserveCarValidCase() {
		boolean isReserved = reservationService.reserve(validCustomerKevin, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);
		assertTrue(isReserved, "This car should be reserved by the customer");
	}

	@Test
	void reserveCarAmongValidCustomers() {
		int preReservationCount = carInventoryService.findInventoryForCar(validCar.getCarId()).getAvailable();

		// Kevin reserved the car
		boolean isReserved = reservationService.reserve(validCustomerKevin, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);

		int postReservationCount = carInventoryService.findInventoryForCar(validCar.getCarId()).getAvailable();
		assertTrue(isReserved, "This car should be reserved by the customer");
		assertEquals(preReservationCount, postReservationCount + 1, "Inventory value should be decreased by 1");

		// John reserved the car
		preReservationCount = carInventoryService.findInventoryForCar(validCar.getCarId()).getAvailable();
		isReserved = reservationService.reserve(validCustomerJohn, validCar, LocalDate.of(2020, Month.SEPTEMBER, 24),
				3);

		postReservationCount = carInventoryService.findInventoryForCar(validCar.getCarId()).getAvailable();
		assertTrue(isReserved, "This car should be reserved by the customer");

		assertEquals(preReservationCount, postReservationCount + 1, "Inventory value should be decreased by 1");

	}

	@Test
	void reserveCarAmongInvalidCustomers() {
		int preReservationCount = carInventoryService.findInventoryForCar(validCarQuantityOne.getCarId())
				.getAvailable();

		// Kevin reserved the car , only single car is available in the inventory
		boolean isReserved = reservationService.reserve(validCustomerKevin, validCarQuantityOne,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);
		int postReservationCount = carInventoryService.findInventoryForCar(validCarQuantityOne.getCarId())
				.getAvailable();

		assertTrue(isReserved, "This car should be reserved by the customer");
		assertEquals(preReservationCount, postReservationCount + 1, "Inventory value should be decreased by 1");

		// John reserved the car
		assertThrows(CarNotAvaiableForRentException.class,
				() -> reservationService.reserve(validCustomerJohn, validCarQuantityOne,
						LocalDate.of(2020, Month.SEPTEMBER, 24), 3),
				"This car has already been reserved by customer, reserve for differnt duration");

	}

	@Test
	void reserveCarOverlappingInvalidCase() {

		boolean isReserved = reservationService.reserve(validCustomerKevin, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3);
		assertTrue(isReserved, "This car has not been by reserved customer,so it can be reserved");

		assertThrows(
				CarNotAvaiableForRentException.class, () -> reservationService.reserve(validCustomerKevin, validCar,
						LocalDate.of(2020, Month.SEPTEMBER, 25), 3),
				"This car has already been reserved by customer, reserve for differnt duration");

	}

	@Test
	void reserveWithInvalidCustomerTest() {
		assertThrows(CustomerNotFoundException.class, () -> reservationService.reserve(inValidCustomer, validCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3));
	}

	@Test
	void reserveWithInvalidCarTest() {
		assertThrows(CarNotFoundException.class, () -> reservationService.reserve(validCustomerKevin, invalidCar,
				LocalDate.of(2020, Month.SEPTEMBER, 25), 3));
	}

	@AfterEach
	void cleanup() {
		ServiceContainer.destroy();
	}
}
