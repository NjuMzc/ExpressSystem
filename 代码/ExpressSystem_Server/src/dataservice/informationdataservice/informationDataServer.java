package dataservice.informationdataservice;

import java.rmi.RemoteException;

import po.InformationPO;

/**
 * information���ݲ����ɾ�Ĳ�
 * @author nick
 *
 */
public interface informationDataServer {
	
	public void insert(InformationPO po) throws RemoteException;
	
	public void delete(InformationPO po)throws RemoteException;
	
	public void update(InformationPO po)throws RemoteException;
	
	public InformationPO find(String id)throws RemoteException;
}
