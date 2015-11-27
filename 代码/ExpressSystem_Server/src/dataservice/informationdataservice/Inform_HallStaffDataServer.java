package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Workers.HallStaffPO;

/**
 * 营业厅业务员的数据层交互接口
 * 增删改查
 * @author rabook
 *
 */
public interface Inform_HallStaffDataServer extends Remote{

	public void addStaff(HallStaffPO staff) throws RemoteException;
	
	public HallStaffPO find(String id)throws RemoteException;
	
	public void deleteStaff(HallStaffPO staff)throws RemoteException;
	
	public void update(HallStaffPO staff)throws RemoteException;
	
}
