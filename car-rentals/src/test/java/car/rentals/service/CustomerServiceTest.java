package car.rentals.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import car.rentals.model.vo.Customer;

class CustomerServiceTest {

	CustomerService customerService = null;
	Customer customer = null;

	@BeforeEach
	void init() {
		customerService = new CustomerService();
		customer = new Customer(203L, "Kevin", "508-ZZZ-ZZZZ");
	}

	@Test
	void getCustomerByIdTest() {
		Customer customer = customerService.getCustomer(203L);
		assertNotNull(customer, "Customer should not be null.");
		assertEquals(203L, customer.getCustomerId(), "Custmer id should be 203");
		assertEquals("Kevin", customer.getName(), "Custmer name should be Kevin");
		assertEquals("508-ZZZ-ZZZZ", customer.getCell(), "Custmer cell number should be 508-ZZZ-ZZZZ");
	}

	@Test
	void getCustomerByReferenceTest() {

		Customer customerFoundReference = customerService.getCustomer(customer);
		assertNotNull(customerFoundReference, "Customer should not be null.");
		assertEquals(203L, customerFoundReference.getCustomerId(), "Custmer id should be 203");
		assertEquals("Kevin", customerFoundReference.getName(), "Custmer name should be Kevin");
		assertEquals("508-ZZZ-ZZZZ", customerFoundReference.getCell(), "Custmer cell number should be 508-ZZZ-ZZZZ");
		assertNotEquals(System.identityHashCode(customerFoundReference), System.identityHashCode(customer),
				"Object reference should be different.");
	}

	@Test
	void isValidCustomerByIdTest() {
		boolean validCustomer = customerService.isValidCustomer(203L);
		assertTrue(validCustomer, "This is valid  customer id and should return true.");

		validCustomer = customerService.isValidCustomer(0000L);
		assertFalse(validCustomer, "This is invalid valid customer id and should return false.");
	}

	@Test
	void isValidCustomerByReferenceTest() {
		boolean validCustomer = customerService.isValidCustomer(customer);
		assertTrue(validCustomer, "This is valid  customer id and should return true.");
	}
}
