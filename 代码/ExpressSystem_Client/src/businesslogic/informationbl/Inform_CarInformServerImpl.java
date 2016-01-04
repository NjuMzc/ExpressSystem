package businesslogic.informationbl;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_CarDataServer;
import po.Institution.HallPO;
import po.Workers.CarPO;
import po.Workers.HallStaffPO;
import businesslogic.systembl.SystemHelper;
import businesslogicservice.informationblservice.WorkerInform.Inform_CarInformServer;

public class Inform_CarInformServerImpl implements Inform_CarInformServer {
	
	Inform_CarDataServer dataServer;
	HallStaffPO staffNow;//当前业务员用户对象
	HallPO hall;//当前业务员所在的营业厅

	Inform_HallStaffInformServerImpl staffServer;
	Inform_HallInformServerImpl hallServer;
	
	public Inform_CarInformServerImpl(){
		//RMI
	    dataServer=RMIHelper.getCarData();
	    
	    staffServer=new Inform_HallStaffInformServerImpl();
		hallServer=new Inform_HallInformServerImpl();
		staffNow=staffServer.getStaff(SystemHelper.getUserID());
		hall=hallServer.getHall(staffNow.getHall().getID());
	}
	
	public Inform_CarInformServerImpl(String hallId){
		//RMI
	    dataServer=RMIHelper.getCarData();
	    
	    staffServer=new Inform_HallStaffInformServerImpl();
		hallServer=new Inform_HallInformServerImpl();
		hall=hallServer.getHall(hallId);
	}

	@Override
	public CarPO addCar(String ChePai, String UsingTime) {
		// TODO Auto-generated method stub
		String flowStr="000";
		int flow=0;
		while(dataServer.getCar(hall.getID()+flowStr)!=null){
			flow++;
			if(flow<=9)
				flowStr="00"+String.valueOf(flow);
			else if(flow<=99)
				flowStr="0"+String.valueOf(flow);
			else if(flow<=999)
				flowStr=String.valueOf(flow);
			else
				return null;
		}
		
		CarPO car=new CarPO(hall.getID()+flowStr, ChePai, UsingTime, hall);
		dataServer.addCar(car);
		hallServer.addCar(hall.getID(), car);	
		
		return car;
	}

	@Override
	public boolean updateCar(String carId, String ChePai, String UsingTime) {
		// TODO Auto-generated method stub
	    CarPO car=dataServer.getCar(carId);
		if(car==null)
			return false;
		Iterator<CarPO> it=hall.getAllCar().iterator();
		{
			while(it.hasNext()){
				if(carId.equals(it.next().getId()))
					it.remove();
			}
		}

	    car.setChePai(ChePai);
	    car.setUsingTime(UsingTime);
	    
	    hall.addCar(car);
	    dataServer.updateCar(car);
	    hallServer.updateHall(hall);
		return true;
	}

	@Override
	public Iterator<CarPO> getAllCar() {
		// TODO Auto-generated method stub
		
		return hall.getAllCar().iterator();
	}

	@Override
	public boolean removeCar(String carId) {
		// TODO Auto-generated method stub

		CarPO car=dataServer.getCar(carId);
		if(car==null)
			return false;
		Iterator<CarPO> it=hall.getAllCar().iterator();
		{
			while(it.hasNext()){
				if(carId.equals(it.next().getId()))
					it.remove();
			}
		}
	    hallServer.updateHall(hall);
	    dataServer.deleteCar(car);

		return true;
	}

	@Override
	public Iterator<CarPO> getAllCar(String hallId) {
		// TODO Auto-generated method stub 
		hall=hallServer.getHall(hallId);
		
		return hall.getAllCar().iterator();
	}

}
