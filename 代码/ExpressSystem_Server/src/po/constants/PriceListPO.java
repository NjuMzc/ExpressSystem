package po.constants;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * 各种各样的价格列表
 * @author rabook
 *
 */
public class PriceListPO implements Serializable,Remote{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5429360673004104582L;

	private double CarPrice;
	
	private double TrainPrice;
	
	private double AirPrice;
	
	private double standardPrice;
	
	private double economicPrice;

	private double expressPrice;
	
	public PriceListPO(){
		this.CarPrice=2;
		this.TrainPrice=0.2;
		this.AirPrice=20;
		this.standardPrice=23;
		this.expressPrice=25;
		this.economicPrice=18;
	}
	
	
	//Getter and Setter
	public double getEconomicPrice() {
		return economicPrice;
	}


	public void setEconomicPrice(double economicPrice) {
		this.economicPrice = economicPrice;
	}


	public double getExpressPrice() {
		return expressPrice;
	}


	public void setExpressPrice(double expressPrice) {
		this.expressPrice = expressPrice;
	}
	public double getCarPrice() {
		return CarPrice;
	}

	public void setCarPrice(double carPrice) {
		CarPrice = carPrice;
	}

	public double getTrainPrice() {
		return TrainPrice;
	}

	public void setTrainPrice(double trainPrice) {
		TrainPrice = trainPrice;
	}

	public double getAirPrice() {
		return AirPrice;
	}

	public void setAirPrice(double airPrice) {
		AirPrice = airPrice;
	}

	public double getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(double standardPrice) {
		this.standardPrice = standardPrice;
	}
}
