package car.rentals.dao;

import java.util.List;

import car.rentals.model.vo.Reservation;

public interface ReservationDao {
	public List<Reservation> getReservations();
	public List<Reservation> getReservationsByCustomer(Long customerId);
	public void addReservation(Reservation reservation);
}
