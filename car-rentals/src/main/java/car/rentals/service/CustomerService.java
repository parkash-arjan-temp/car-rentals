package car.rentals.service;

import java.util.List;

import car.rentals.dao.CustomerDao;
import car.rentals.dao.local.impl.LocalCustomerDaoImpl;
import car.rentals.model.vo.Customer;

public class CustomerService {
	private CustomerDao customerDao;

	public CustomerService() {
		customerDao = new LocalCustomerDaoImpl();
	}

	public boolean isValidCustomer(Customer customer) {
		return customer.equals(getCustomer(customer.getCustomerId()));
	}

	public boolean isValidCustomer(Long customerId) {
		return customerDao.find(customerId) != null;
	}

	public Customer getCustomer(Long customerId) {
		return customerDao.find(customerId);
	}

	public Customer getCustomer(Customer customer) {
		return customerDao.find(customer.getCustomerId());
	}

	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
}
