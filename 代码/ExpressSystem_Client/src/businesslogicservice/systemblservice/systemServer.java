package businesslogicservice.systemblservice;

import java.util.ArrayList;

import po.Message;
import po.SystemUserPO;
import vo.SystemUserVO;

/**
 * 系统管理员相关功能的接口
 * 登录管理
 * 系统用户增删改查
 * @author rabook
 *
 */
public interface systemServer {
	
	public SystemUserVO login(String id,String key) ;//处理登录
	
	public SystemUserPO addUser(String identity);
	
	public boolean removeUser(String id);
	
	public void changeUser(String name,Message message);
	
	public SystemUserPO inquire(String id);
	
	public int getUserNum();
	
	public ArrayList getAllUsers();

}
