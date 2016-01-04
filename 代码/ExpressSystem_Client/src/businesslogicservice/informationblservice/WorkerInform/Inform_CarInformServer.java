package businesslogicservice.informationblservice.WorkerInform;

import java.util.Iterator;

import po.Workers.CarPO;

public interface Inform_CarInformServer {

	public CarPO addCar(String ChePai,String UsingTime);
	
	public boolean updateCar(String carId,String ChePai,String UsingTime);
	
	public Iterator<CarPO> getAllCar();
	
	public Iterator<CarPO> getAllCar(String hallId);
	
	public boolean removeCar(String carId);
}
