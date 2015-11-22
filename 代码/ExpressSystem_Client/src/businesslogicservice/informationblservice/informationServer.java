package businesslogicservice.informationblservice;

import po.Message;
import businesslogic.informationbl.*;



/**
 * 
 * @author rabook
 *
 */
public interface informationServer {
	
	public void addWorker(Message message);
	
	public void addInstitution(Message message);
	
	public void addCar(Message message);
	
	public boolean removeWorker(String id);
	
	public boolean removeInstitution(String id);
	
	public boolean removeCar(String id);
	
	public boolean changeWorker(String id,Message message);
	
	public boolean changeInstitution(String id,Message message);
	
	public boolean changeCar(String id,Message message);
	
	public WorkerInform getWorkerInform(String id);
	
	public InstituteInform getInstitutionInform(String id);
	
	public CarInform getCarInform(String id);
	
}
