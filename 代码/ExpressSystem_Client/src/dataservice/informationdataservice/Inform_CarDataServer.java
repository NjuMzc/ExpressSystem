package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Workers.CarPO;

public interface Inform_CarDataServer extends Remote{

	public void addCar(CarPO car);
	
	public CarPO getCar(String carId);
	
	public boolean updateCar(CarPO car);
	
	public boolean deleteCar(CarPO car);
}
