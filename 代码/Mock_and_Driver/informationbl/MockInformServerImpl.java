package Mock_and_Driver.informationbl;

import po.Message;
import businesslogic.informationbl.CarInform;
import businesslogic.informationbl.InformServerImpl;
import businesslogic.informationbl.InstituteInform;
import businesslogic.informationbl.WorkerInform;

public class MockInformServerImpl extends InformServerImpl{
	
	public void addWorker(Message message) {
		// TODO Auto-generated method stub
		WorkerInform infor=new MockWorkerInform();
	   System.out.println("Worker is added");	
	}

	public void addInstitution(Message message) {
		// TODO Auto-generated method stub
		InstituteInform infor=new MockInstituteInform();
		System.out.println("Institution is added!");
	}

	public void addCar(Message message) {
		// TODO Auto-generated method stub
		CarInform infor=new MockCarInform();
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
