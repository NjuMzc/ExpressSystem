package client.businesslogicservice.informationblservice;

import client.vo.InstitutionVO;
import client.vo.Message;
import client.vo.WorkerVO;


/**
 * 该接口提供关于人员与机构信息管理的服务
 * 包括人员信息、车辆信息、机构信息
 * 这里只需要Worker与Institution两个VO，车辆信息视为人员信息
 * 方法为增删改查
 * @author rabook
 *
 */
public interface informationServer {
	
	public WorkerVO addWorker(Message message);
	
	public InstitutionVO addInstitution(Message message);
	
	public boolean removeWorker(String id);
	
	public boolean removeInstitution(String id);
	
	public boolean changeWorker(String id,Message message);
	
	public boolean changeInstitution(String id,Message message);
	
	public WorkerVO inquireWorker(String id);
	
	public InstitutionVO inquireInstitution(String id);
	
}
