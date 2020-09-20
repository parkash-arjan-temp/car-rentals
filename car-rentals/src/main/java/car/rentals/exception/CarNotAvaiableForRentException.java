package car.rentals.exception;

public class CarNotAvaiableForRentException extends RuntimeException {

	private static final long serialVersionUID = -1328091821125443389L;

	public CarNotAvaiableForRentException(String message) {
		super(message);
	}
}
