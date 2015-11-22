package Mock_and_Driver.systembl;

import po.SystemUserPO;

public class MockSystemUser extends SystemUserPO{
	public MockSystemUser(String id, String key, String identity) {
		super(id, key, identity, identity);
		// TODO Auto-generated constructor stub
	}

	String name;
	String password;
	
	String identity;
	

}
