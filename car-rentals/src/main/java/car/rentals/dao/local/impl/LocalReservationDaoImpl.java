package car.rentals.dao.local.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import car.rentals.model.vo.Reservation;

public class LocalReservationDaoImpl extends AbstractReservationDao {

	private List<Reservation> reservations;

	public LocalReservationDaoImpl() {
		// Modifiable collection
		reservations = new ArrayList<>(Arrays.asList(

				new Reservation(501L, 301L, 201L, LocalDate.of(2020, Month.SEPTEMBER, 19),
						LocalDate.of(2020, Month.SEPTEMBER, 23), 5),

				new Reservation(502L, 301L, 202L, LocalDate.of(2020, Month.SEPTEMBER, 19),
						LocalDate.of(2020, Month.SEPTEMBER, 20), 2),

				new Reservation(503L, 302L, 202L, LocalDate.of(2020, Month.SEPTEMBER, 19),
						LocalDate.of(2020, Month.SEPTEMBER, 20), 2),

				new Reservation(504L, 302L, 203L, LocalDate.of(2020, Month.SEPTEMBER, 19),
						LocalDate.of(2020, Month.SEPTEMBER, 23), 5)));
	}

	public List<Reservation> getReservations() {
		return reservations;

	}

	public void addReservation(Reservation reservation) {
		// In actual application it should done via sequencer or some id generator.
		reservation.setReservationId(getNextReservationId());
		reservations.add(reservation);
	}

	private Long getNextReservationId() {
		Reservation reservation = getReservations()
				.stream()
				.max(Comparator.comparing(Reservation::getReservationId))
				.orElseThrow(NoSuchElementException::new);
		return reservation.getReservationId() + 1L;
	}
}