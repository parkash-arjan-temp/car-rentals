package car.rentals.exception;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4620922304765413108L;

	public CarNotFoundException(String message) {
		super(message);
	}
}
