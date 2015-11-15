package Mock_and_Driver.systembl;

import client.businesslogic.systembl.SystemUser;

public class MockSystemUser extends SystemUser{
	String name;
	String password;
	
	String identity;
	
	public MockSystemUser(){
		System.out.println("An user is created!");
	}

}
