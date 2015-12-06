package businesslogicservice.informationblservice.WorkerInform;

import java.util.Iterator;

import po.Workers.DriverPO;

public interface Inform_DriverInformServer {
	public DriverPO addDriver(String name,String birth,String ShenFenZheng,String mobile,String sex,String portTime);
	
	public boolean updateDriver(String id,String name,String birth,String ShenFenZheng,String mobile,String sex,String portTime);
	
	public Iterator<DriverPO> getAllDriver();
	
	public boolean removeDriver(String DriverId);
}
