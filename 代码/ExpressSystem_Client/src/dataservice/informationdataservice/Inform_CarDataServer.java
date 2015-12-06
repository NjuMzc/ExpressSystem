package dataservice.informationdataservice;

import po.Workers.CarPO;

public interface Inform_CarDataServer {

	public void addCar(CarPO car);
	
	public CarPO getCar(String carId);
	
	public boolean updateCar(CarPO car);
	
	public boolean deleteCar(CarPO car);
}
