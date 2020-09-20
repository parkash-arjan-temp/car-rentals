package car.rentals.dao;

import java.util.List;

import car.rentals.model.vo.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();
	public Customer find(Long id);

}
