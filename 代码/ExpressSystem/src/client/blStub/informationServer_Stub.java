package client.blStub;

import client.businesslogicservice.informationblservice.informationServer;
import client.vo.InstitutionVO;
import client.vo.Message;
import client.vo.WorkerVO;

public class informationServer_Stub implements informationServer {

	public WorkerVO addWorker(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Worker is added");
		return null;
	}

	public InstitutionVO addInstitution(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Institution is added");
		return null;
	}

	public boolean removeWorker(String id) {
		// TODO Auto-generated method stub
		System.out.println("Worker is removed");
		return false;
	}

	public boolean removeInstitution(String id) {
		// TODO Auto-generated method stub
		System.out.println("Institution is removed");
		return false;
	}

	public boolean changeWorker(String id, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Worker is changed");
		return false;
	}

	public boolean changeInstitution(String id, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Institution is changed");
		return false;
	}

	public WorkerVO inquireWorker(String id) {
		// TODO Auto-generated method stub
		System.out.println("Worker is inquired");
		return null;
	}

	public InstitutionVO inquireInstitution(String id) {
		// TODO Auto-generated method stub
		System.out.println("Institution is inquired");
		return null;
	}

}
