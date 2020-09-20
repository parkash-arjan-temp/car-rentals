package car.rentals.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -548968591099062698L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
