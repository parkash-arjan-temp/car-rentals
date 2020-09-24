package car.rentals.dao.local.impl;

import java.util.List;
import java.util.stream.Collectors;

import car.rentals.dao.ReservationDao;
import car.rentals.model.vo.Reservation;

public abstract class AbstractReservationDao implements ReservationDao {
	public List<Reservation> getReservationsByCustomer(Long customerId) {
		return getReservations()
				.stream()
				.filter(reservation -> reservation.getCustomerId().longValue() == customerId.longValue())
				.collect(Collectors.toList());

	}
}
