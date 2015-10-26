package client.dataservice.billsdataservice;


import java.rmi.RemoteException;

import client.po.*;

/**
 * bill数据层的增、改、查借口
 * @author nick
 *
 */
public interface billsDataServer {
	
	public BillPO find(String id) throws RemoteException;

	public void insert(BillPO po) throws RemoteException;
	
	public void update(BillPO po) throws RemoteException;
	

}
