package businesslogic.systembl;

import java.util.ArrayList;

import client.RMIHelper;
import po.Message;
import po.SystemUserPO;
import businesslogicservice.systemblservice.systemServer;
import dataservice.systemdataservice.SystemDataServer;

/**
 * 系统管理员操作的实现
 * @author rabook
 *
 */
public class SystemBlServerImpl implements systemServer {
	
	SystemDataServer dataServer;

	public SystemBlServerImpl()  {
		dataServer=RMIHelper.getSystemData();
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

		if (user == null){
			System.out.println("该用户名不存在！");
			return null;
		}
		else {
			if (user.getKey().equals(key))
				return user;
			else{
				System.out.println("密码错误！");
				return null;
			}
				
		}

	}
    
	/*
	 * 添加系统用户的实现
	 * 输入只需要身份类型
	 * @see client.businesslogicservice.systemblservice.systemServer#addUser(client.vo.Message)
	 */

	public SystemUserPO addUser(String identity) {
		// TODO Auto-generated method
		String id="";
		String mark="";
		String key="nova123321";
		String userName="User";
		
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
		id="20150"+mark+count;
		SystemUserPO user=new SystemUserPO(id, key, identity, userName);
		
		dataServer.insert(user);
		return user;
	}

	/*
	 * 移除一个已有的用户
	 * @param 用户账号名
	 * @return 成功返回true，失败返回false
	 * @see client.businesslogicservice.systemblservice.systemServer#removeUser(java.lang.String)
	 */
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

	/*
	 * 修改已有账户的信息
	 * 第一项是姓名， 第二项是密码
	 * @see client.businesslogicservice.systemblservice.systemServer#changeUser(java.lang.String, client.vo.Message)
	 */
	public void changeUser(String id, Message message) {
		// TODO Auto-generated method stub
		SystemUserPO user =dataServer.find(id);
		
		if(user==null){
			System.out.println("用户不存在");
		}else{
			user.setName(message.getInform(0));
			user.setKey(message.getInform(1));
		}
		
	}

	/*
	 * 通过账户查询一个用户
	 * @see client.businesslogicservice.systemblservice.systemServer#inquire(java.lang.String)
	 */
	public SystemUserPO inquire(String id) {
		// TODO Auto-generated method stub
		SystemUserPO user =dataServer.find(id);

		if (user == null)
			return null;
		else {
		    return user;
		}
		
	}

	/*
	 * 返回系统用户数量
	 * @see businesslogicservice.systemblservice.systemServer#getUserNum()
	 */
	public int getUserNum() {
		// TODO Auto-generated method stub
		return dataServer.getUserNum();
	}

	/*
	 * 返回一个包含当前所有系统用户的链表
	 * @see businesslogicservice.systemblservice.systemServer#getAllUsers()
	 */
	@Override
	public ArrayList<SystemUserPO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


}
