package businesslogicservice.constantblservice;

public interface PriceListServer {

	public double getCarPrice();
	
	public double getTrainPrice();
	
	public double getAirPrice();
	
	public double getStandardPrice();
	
	public double getExpressPrice();
	
	public double getEconomicPrice();
	
	public void setCarPrice(double price);
	
	public void setTrainPrice(double price);
	
	public void setAirPrice(double price);
	
	public void setStandardPrice(double price);
	
	public void setExpressPrice(double price);
	
	public void setEconomicPrice(double price);
	
}
