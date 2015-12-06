package dataservice.constantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.constants.PriceListPO;

public interface PriceListDataServer extends Remote {

	public PriceListPO get() throws RemoteException;

	public void update(PriceListPO priceList) throws RemoteException;
}
