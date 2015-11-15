package Mock_and_Driver;

import client.businesslogic.informationbl.CarInform;
import client.businesslogic.informationbl.InformServerImpl;
import client.businesslogic.informationbl.InstituteInform;
import client.businesslogic.informationbl.WorkerInform;
import client.vo.Message;

public class MockInformServerImpl extends InformServerImpl{
	
	public void addWorker(Message message) {
		// TODO Auto-generated method stub
	   System.out.println("Worker is added");	
	}

	public void addInstitution(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Institution is added!");
	}

	public void addCar(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Car is added!");
	}

	public boolean removeWorker(String id) {
		// TODO Auto-generated method stub
		System.out.println("Worker is removed!");
		return false;
	}

	public boolean removeInstitution(String id) {
		// TODO Auto-generated method stub
		System.out.println("Institution is removed!");
		return false;
	}

	public boolean removeCar(String id) {
		// TODO Auto-generated method stub
		System.out.println("Car is removed!");
		return false;
	}

	public boolean changeWorker(String id, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Worker is changed!");
		return false;
	}

	public boolean changeInstitution(String id, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Institution is changed!");
		return false;
	}

	public boolean changeCar(String id, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Car is changed!");
		return false;
	}

	public WorkerInform getWorkerInform(String id) {
		// TODO Auto-generated method stub
		System.out.println("Worker Information is got!");
		return null;
	}

	public InstituteInform getInstitutionInform(String id) {
		// TODO Auto-generated method stub
		System.out.println("Institution  Inform is got!");
		return null;
	}

	public CarInform getCarInform(String id) {
		// TODO Auto-generated method stub
		System.out.println("Car Information is got!");
		return null;
	}
}
