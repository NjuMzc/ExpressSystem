package businesslogic.constantbl;

import client.RMIHelper;
import po.constants.PriceListPO;
import dataservice.constantdataservice.PriceListDataServer;
import businesslogicservice.constantblservice.PriceListServer;

public class PriceListServerImpl implements PriceListServer {
	PriceListDataServer dataServer;
	
	PriceListPO list;
	
	public PriceListServerImpl(){
		//RMI
		dataServer=RMIHelper.getPriceListData();
		
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

	@Override
	public void setCarPrice(double price) {
		// TODO Auto-generated method stub
		list.setCarPrice(price);
		dataServer.update();
	}

	@Override
	public void setTrainPrice(double price) {
		// TODO Auto-generated method stub
		list.setTrainPrice(price);
		dataServer.update();
	}

	@Override
	public void setAirPrice(double price) {
		// TODO Auto-generated method stub
		list.setAirPrice(price);
		dataServer.update();
	}

	@Override
	public void setStandardPrice(double price) {
		// TODO Auto-generated method stub
		list.setStandardPrice(price);
		dataServer.update();
	}

	@Override
	public void setExpressPrice(double price) {
		// TODO Auto-generated method stub
		list.setExpressPrice(price);
		dataServer.update();
	}

	@Override
	public void setEconomicPrice(double price) {
		// TODO Auto-generated method stub
		list.setEconomicPrice(price);
		dataServer.update();
		
	}




}
