package car.rentals.dao.local.impl;

import car.rentals.dao.CustomerDao;
import car.rentals.model.vo.Customer;

public abstract class AbstractCustomerDao implements CustomerDao {

	public Customer find(Long id) {
		return getCustomers()
				.stream()
				.filter(customer -> customer.getCustomerId().longValue() == id.longValue())
				.findAny()
				.orElse(null);
	}
}
