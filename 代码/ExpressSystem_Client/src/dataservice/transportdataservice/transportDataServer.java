package dataservice.transportdataservice;

import java.rmi.RemoteException;

import po.GoodPO;

/**
 * ��������ݲ�ӿ������ġ���
 * 
 * @author nick
 *
 */
public interface transportDataServer {
	public void insert(GoodPO po) throws RemoteException;

	public void update(GoodPO po) throws RemoteException;

	public GoodPO find(String id) throws RemoteException;
}
