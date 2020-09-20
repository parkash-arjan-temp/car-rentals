package car.rentals.model.vo;

public class CarType {
	private Long carTypeId;
	private String type;

	public CarType() {

	}

	public CarType(Long carTypeId, String type) {
		this.carTypeId = carTypeId;
		this.type = type;
	}

	public Long getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Long carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carTypeId == null) ? 0 : carTypeId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CarType other = (CarType) obj;
		if (carTypeId == null) {
			if (other.carTypeId != null)
				return false;
		} else if (!carTypeId.equals(other.carTypeId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("CarType [carTypeId=%s, type=%s]", carTypeId, type);
	}

}
