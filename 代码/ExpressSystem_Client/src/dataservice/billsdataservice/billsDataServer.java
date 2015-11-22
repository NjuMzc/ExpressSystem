package dataservice.billsdataservice;


import java.rmi.RemoteException;

import po.*;

/**
 * bill���ݲ�������ġ�����
 * @author nick
 *
 */
public interface billsDataServer {
	
	public BillPO find(String id) throws RemoteException;

	public void insert(BillPO po) throws RemoteException;
	
	public void update(BillPO po) throws RemoteException;
	

}
