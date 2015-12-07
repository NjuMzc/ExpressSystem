package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Workers.CarPO;

public interface Inform_CarDataServer extends Remote{

	public void addCar(CarPO car)throws RemoteException;
	
	public CarPO getCar(String carId)throws RemoteException;
	
	public boolean updateCar(CarPO car)throws RemoteException;
	
	public boolean deleteCar(CarPO car)throws RemoteException;
}
