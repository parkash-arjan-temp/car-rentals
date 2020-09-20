package car.rentals.model.vo;

public class CarInventory {
	private Long inventoryId;
	private Long carId;
	private int available;
	private int rented;
	private int total;

	public CarInventory() {
	}

	public CarInventory(Long inventoryId, Long carId, int available, int rented, int total) {
		this.inventoryId = inventoryId;
		this.carId = carId;
		this.available = available;
		this.rented = rented;
		this.total = total;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getRented() {
		return rented;
	}

	public void setRented(int rented) {
		this.rented = rented;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + available;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result + rented;
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarInventory other = (CarInventory) obj;
		if (available != other.available)
			return false;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		if (rented != other.rented)
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("CarInventory [inventoryId=%s, carId=%s, available=%s, rented=%s, total=%s]", inventoryId,
				carId, available, rented, total);
	}

}
