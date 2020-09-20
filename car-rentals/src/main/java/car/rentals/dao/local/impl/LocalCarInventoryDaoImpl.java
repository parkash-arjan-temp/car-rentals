package car.rentals.dao.local.impl;

import java.util.Arrays;
import java.util.List;

import car.rentals.model.vo.CarInventory;

public class LocalCarInventoryDaoImpl extends AbstractCarInventoryDao {

	public List<CarInventory> getCarInventory() {
		return Arrays.asList(new CarInventory(401L, 301L, 20, 2, 22), new CarInventory(402L, 302L, 15, 2, 17),
				new CarInventory(403L, 303L, 5, 0, 5), new CarInventory(404L, 304L, 5, 0, 5));
	}

}
