package client.businesslogic.systembl;

import client.businesslogicservice.systemblservice.systemServer;
import server.data.systemdata.*;
import client.dataservice.systemdataservice.systemDataServer;
import client.dataservice.systemdataservice.systemDataServer_Stub;
import client.po.SystemUserPO;
import client.vo.Message;
import client.vo.SystemUserVO;

public class SystemBlServerImpl implements systemServer {

	systemDataServer dataServer;

	public SystemBlServerImpl() {
		this.dataServer = (systemDataServer) new SystemDataServerImpl();
	}

	/*
	 * 登录的实现
	 * 
	 * @parameter id,key
	 * 
	 * @return SystemUserVO
	 * 
	 * @see
	 */
	public SystemUserVO login(String id, String key) {
		// TODO Auto-generated method stub
		SystemUserVO user = (SystemUserVO) dataServer.find(id);

		if (user == null)
			return null;
		else {
			if (user.getKey().equals(id))
				return user;
			else
				return null;
		}

	}

	public SystemUserVO addUser(Message message) {
		// TODO Auto-generated method stub
		SystemUserPO user=new SystemUserPO(message.getInform(0), message.getInform(1), message.getInform(2));
		dataServer.insert(user);
		return (SystemUserVO) user;
	}

	public boolean removeUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void changeUser(String name, Message message) {
		// TODO Auto-generated method stub

	}

	public SystemUserVO inquire(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
