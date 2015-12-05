package dataservice.constantdataservice;

import po.constants.PriceListPO;

public interface PriceListDataServer {

	public void add(PriceListPO list);
	
	public PriceListPO get();
	
	public void update();
}
