package businesslogic.systembl;

import java.util.Comparator;

import po.SystemUserPO;

public class SystemComparer implements Comparator<SystemUserPO>{

	@Override
	public int compare(SystemUserPO arg0, SystemUserPO arg1) {
		// TODO Auto-generated method stub
		int a=Integer.valueOf(arg0.getID());
		int b=Integer.valueOf(arg1.getID());
		if(a>b)
			return 1;
		else if(a==b)
			return 0;
		else 
			return -1;
	}

}
