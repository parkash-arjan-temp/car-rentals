package car.rentals.model.vo;

import java.time.LocalDate;

public class Reservation {
	private Long reservationId;
	private Long carId;
	private Long customerId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int daysRented;

	public Reservation() {
	}

	public Reservation(Long reservationId, Long carId, Long customerId, LocalDate startDate, LocalDate endDate,
			int daysRented) {
		this.reservationId = reservationId;
		this.carId = carId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.daysRented = daysRented;
	}

	public Reservation(Long carId, Long customerId, LocalDate startDate, LocalDate endDate, int daysRented) {
		this.carId = carId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.daysRented = daysRented;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long cardId) {
		this.carId = cardId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + daysRented;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((reservationId == null) ? 0 : reservationId.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Reservation other = (Reservation) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (daysRented != other.daysRented)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (reservationId == null) {
			if (other.reservationId != null)
				return false;
		} else if (!reservationId.equals(other.reservationId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Reservation [reservationId=%s, carId=%s, customerId=%s, startDate=%s, endDate=%s, daysRented=%s]",
				reservationId, carId, customerId, startDate, endDate, daysRented);
	}

}
