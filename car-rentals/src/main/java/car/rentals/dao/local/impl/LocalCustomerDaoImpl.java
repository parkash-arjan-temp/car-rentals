package car.rentals.dao.local.impl;

import java.util.Arrays;
import java.util.List;

import car.rentals.model.vo.Customer;

public class LocalCustomerDaoImpl extends AbstractCustomerDao {

	public List<Customer> getCustomers() {
		return Arrays.asList(
				new Customer(201L, "John", "508-XXX-XXXX"), 
				new Customer(202L, "Baran", "508-YYY-YYYY"),
				new Customer(203L, "Kevin", "508-ZZZ-ZZZZ"));
	}
}
