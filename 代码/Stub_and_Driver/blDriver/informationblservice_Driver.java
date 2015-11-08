package client.blDriver;

import client.businesslogicservice.informationblservice.informationServer;
import client.vo.Message;

public class informationblservice_Driver {

	public void drive(informationServer i, Message m) {
		System.out.println("This is informationblservice_Driver");

		i.addInstitution(m);
		i.addWorker(m);
		i.changeInstitution("4", m);
		i.changeWorker("d", m);
		i.removeInstitution("3");
		i.removeWorker("2");
		i.inquireInstitution("3");
		i.inquireWorker("34");
	}
}
