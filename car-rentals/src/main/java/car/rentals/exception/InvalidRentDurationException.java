package car.rentals.exception;

public class InvalidRentDurationException extends RuntimeException {

	private static final long serialVersionUID = -4009359386553627623L;

	public InvalidRentDurationException(String message) {
		super(message);
	}
}
