package client.businesslogicservice.systemblservice;

import client.vo.Message;
import client.vo.SystemUserVO;

/**
 * 该接口提供关于系统相关的服务
 * 包括
 * 系统登录与系统账号管理
 * 方法为登录、增删改查
 * @author rabook
 *
 */
public interface systemServer {
	
	public boolean login(String id,String key);
	
	public SystemUserVO addUser(Message message);
	
	public boolean removeUser(String id);
	
	public void changeUser(String name,Message message);
	
	public SystemUserVO inquire(String id);
	
	

}
