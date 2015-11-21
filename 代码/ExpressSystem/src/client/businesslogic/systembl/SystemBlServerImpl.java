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
		String identity=message.getInform(0);
		String id="";
		String mark="";
		String key="nova123321";
		String userName=message.getInform(1);
		
		//自动分配id
		switch(identity){
		case "manager":
			mark="1";
			break;
		case "account":
			mark="2";
			break;
		case "courier":
			mark="3";
			break;
		case "hstaff":
			mark="4";
			break;
		case "tstaff":
			mark="5";
			break;
		case "keeper":
			mark="6";
			break;
		case "admin":
			mark="7";
			break;
		}
		int counter=0;
		String count="0000";
		while(dataServer.find("20150"+mark+count)!=null){
			counter++;
			if(counter<=9){
				count="000"+counter;
			}else if(counter<=99){
				count="00"+counter;
			}else if(counter<=999){
				count="0"+counter;
			}else{
				System.out.println("用户名已使用完！");
			}
		}
		
		SystemUserPO user=new SystemUserPO("20150"+mark+count, key, identity, userName);
		
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
