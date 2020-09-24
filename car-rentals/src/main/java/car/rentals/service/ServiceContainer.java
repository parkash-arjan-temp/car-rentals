package car.rentals.service;

public final class ServiceContainer {

	private static ServiceContainer serviceContainer = null;
	private ReservationService reservationService = null;
	private CustomerService customerService = null;
	private CarService carService = null;
	private CarInventoryService carInventoryService = null;

	private ServiceContainer() {

	}

	public static synchronized ServiceContainer getInstance() {
		if (serviceContainer == null) {
			serviceContainer = new ServiceContainer();
		}

		return serviceContainer;
	}

	public ReservationService getReservationService() {

		if (reservationService == null) {
			reservationService = new ReservationService();
		}
		return reservationService;
	}

	public CustomerService getCustomerService() {

		if (customerService == null) {
			customerService = new CustomerService();
		}
		return customerService;

	}

	public CarService getCarService() {

		if (carService == null) {
			carService = new CarService();
		}
		return carService;

	}

	public CarInventoryService getCarInventoryService() {

		if (carInventoryService == null) {
			carInventoryService = new CarInventoryService();
		}
		return carInventoryService;

	}

	public static void destroy() {
		serviceContainer = null;
	}

}
