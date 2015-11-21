package client.businesslogic.systembl;

import client.businesslogicservice.systemblservice.systemServer;
import server.data.systemdata.*;
import server.dataservice.systemdataservice.*;
import client.po.SystemUserPO;
import client.vo.Message;
import client.vo.SystemUserVO;

public class SystemBlServerImpl implements systemServer {

	systemDataServer dataServer;

	public SystemBlServerImpl() {
		this.dataServer =new SystemDataServerImpl();
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
	public SystemUserPO login(String id, String key) {
		// TODO Auto-generated method stub
		SystemUserPO user =dataServer.find(id);

		if (user == null)
			return null;
		else {
			if (user.getKey().equals(key))
				return user;
			else
				return null;
		}

	}

	public SystemUserPO addUser(Message message) {
		// TODO Auto-generated method stub
		SystemUserPO user=new SystemUserPO(message.getInform(0), message.getInform(1), message.getInform(2));
		dataServer.insert(user);
		return user;
	}

	public boolean removeUser(String id) {
		// TODO Auto-generated method stub
		SystemUserPO user =dataServer.find(id);
		if(user==null){
			return false;
		}else{
			dataServer.delete(user);
			return true;
		}
		
	}

	public void changeUser(String name, Message message) {
		// TODO Auto-generated method stub
        
	}

	public SystemUserVO inquire(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getUserNum() {
		// TODO Auto-generated method stub
		
		return dataServer.getUserNum();
	}

}
