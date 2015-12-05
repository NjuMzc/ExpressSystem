package businesslogic.constantbl;

import po.constants.PriceListPO;
import dataservice.constantdataservice.PriceListDataServer;
import businesslogicservice.constantblservice.PriceListServer;

public class PriceListServerImpl implements PriceListServer {
	PriceListDataServer dataServer;
	
	PriceListPO list;
	
	public PriceListServerImpl(){
		//RMI
		
		list=dataServer.get();
		
	}

	@Override
	public double getCarPrice() {
		// TODO Auto-generated method stub
		return list.getCarPrice();
	}

	@Override
	public double getTrainPrice() {
		// TODO Auto-generated method stub
		return list.getTrainPrice();
	}

	@Override
	public double getAirPrice() {
		// TODO Auto-generated method stub
		return list.getAirPrice();
	}

	@Override
	public double getStandardPrice() {
		// TODO Auto-generated method stub
		return list.getStandardPrice();
	}

	@Override
	public double getExpressPrice() {
		// TODO Auto-generated method stub
		return list.getExpressPrice();
	}

	@Override
	public double getEconomicPrice() {
		// TODO Auto-generated method stub
		return list.getEconomicPrice();
	}

}
