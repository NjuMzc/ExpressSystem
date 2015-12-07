package businesslogic.informationbl;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_DriverDataServer;
import po.Institution.HallPO;
import po.Workers.DriverPO;
import po.Workers.HallStaffPO;
import businesslogic.systembl.SystemHelper;
import businesslogicservice.informationblservice.WorkerInform.Inform_DriverInformServer;

public class Inform_DriverInformServerImpl implements Inform_DriverInformServer {
	Inform_DriverDataServer dataServer;
	HallStaffPO staffNow;//当前业务员用户对象
	HallPO hall;//当前业务员所在的营业厅

	Inform_HallStaffInformServerImpl staffServer;
	Inform_HallInformServerImpl hallServer;
	
	public Inform_DriverInformServerImpl(){
		
		dataServer=RMIHelper.getDriverData();
		
		staffServer=new Inform_HallStaffInformServerImpl();
		hallServer=new Inform_HallInformServerImpl();
		staffNow=staffServer.getStaff(SystemHelper.getUserID());
		hall=hallServer.getHall(staffNow.getHall().getID());
		
	}
	@Override
	public DriverPO addDriver(String name, String birth, String ShenFenZheng,
			String mobile, String sex, String portTime) {
		// TODO Auto-generated method stub
		String flowStr="000";
		int flow=0;
		while(dataServer.getDriver(hall.getID()+flowStr)!=null){
			flow++;
			if(flow<=9)
				flowStr="00"+String.valueOf(flow);
			else if(flow<=99)
				flowStr="0"+String.valueOf(flow);
			else if(flow<=999)
				flowStr=String.valueOf(flow);
			else
				return null;
		}
		
		DriverPO driver=new DriverPO(hall.getID()+flowStr, name, birth, ShenFenZheng, mobile, sex, portTime);
		driver.setHall(hall);
		dataServer.addDriver(driver);
		hallServer.addDriver(staffNow.getHall().getID(), driver);	
		return driver;
	}

	@Override
	public boolean updateDriver(String id, String name, String birth,
			String ShenFenZheng, String mobile, String sex, String portTime) {
		// TODO Auto-generated method stub
		DriverPO driver=dataServer.getDriver(id);
		if(driver==null)
			return false;
		Iterator<DriverPO> it=hall.getAllDriver().iterator();
		{
			while(it.hasNext()){
				if(id.equals(it.next().getId()))
					it.remove();
			}
		}
		driver.setBirth(birth);
		driver.setSex(sex);
		driver.setMobileNum(mobile);
		driver.setName(name);
		driver.setShenFenZheng(ShenFenZheng);
		driver.setPortTime(portTime);
		
		
		hall.addDriver(driver);
		dataServer.updateDriver(driver);
		hallServer.updateHall(hall);
		return true;
	}

	@Override
	public Iterator<DriverPO> getAllDriver() {
		// TODO Auto-generated method stub
		hall=hallServer.getHall((staffNow.getHall().getID()));
		Iterator<DriverPO> list=hall.getAllDriver().iterator();
		return list;
		
	}

	@Override
	public boolean removeDriver(String DriverId) {
		// TODO Auto-generated method stub
		hall=hallServer.getHall((staffNow.getHall().getID()));
		DriverPO driver=dataServer.getDriver(DriverId);
		if(driver==null)
			return false;
		Iterator<DriverPO> it=hall.getAllDriver().iterator();
		{
			while(it.hasNext()){
				if(DriverId.equals(it.next().getId()))
					it.remove();
			}
		}
				
		hallServer.updateHall(hall);

		dataServer.deleteDriver(driver);
		return true;
	}

}
