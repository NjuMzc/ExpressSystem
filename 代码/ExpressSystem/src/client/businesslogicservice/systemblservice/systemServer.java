package client.businesslogicservice.systemblservice;

import client.po.SystemUserPO;
import client.vo.Message;
import client.vo.SystemUserVO;

/**
 * 系统管理员相关功能的接口
 * 登录管理
 * 系统用户增删改查
 * @author rabook
 *
 */
public interface systemServer {
	
	public SystemUserPO login(String id,String key);
	
	public SystemUserVO addUser(Message message);
	
	public boolean removeUser(String id);
	
	public void changeUser(String name,Message message);
	
	public SystemUserVO inquire(String id);
	
	

}
