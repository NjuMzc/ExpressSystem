package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 营业厅信息数据层交互接口
 * 增删改查
 */
import po.Institution.HallPO;

public interface Inform_HallDataServer extends Remote {

	public void addHall(HallPO hall) throws RemoteException;

	public HallPO find(String id) throws RemoteException;

	public void deleteHall(HallPO hall) throws RemoteException;

	public void updateHall(HallPO hall) throws RemoteException;

}
