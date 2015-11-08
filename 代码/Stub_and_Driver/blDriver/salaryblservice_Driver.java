package client.blDriver;

import client.businesslogicservice.salaryblservice.salaryServer;
import client.dataservice.systemdataservice.systemDataServer;
import client.vo.Message;

public class salaryblservice_Driver {
         
	      public void drive(salaryServer salaryserver,Message message){
	    	  System.out.println("This is salaryblservice_Driver");
	    	  salaryserver.getSalary(message);
	    	  salaryserver.setSalary(message);
	      }
}
