package client.dataStub;

import client.dataservice.salarydataservice.salaryDataServer;
import client.po.SalaryPO;
import client.vo.Message;

public class salaryDataServer_Stub implements salaryDataServer{

	public SalaryPO find(String id) {
		// TODO Auto-generated method stub
		System.out.println("A SalaryPO is found in data!");
		return null;
	}

	public SalaryPO insert(Message message) {
		// TODO Auto-generated method stub
		System.out.println("A SalaryPO is added in data!");
		return null;
	}

}
