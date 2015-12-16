package businesslogic.billsbl.ChargeBillServer;

import java.util.ArrayList;
import java.util.Iterator;

import po.SystemUserPO;
import po.Workers.HallStaffPO;
import po.bills.ChargeBill;
import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogic.informationbl.Inform_HallStaffInformServerImpl;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogic.systembl.SystemHelper;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.ChargeBillDataServer;

public class ChargeBillServer {
	ChargeBillDataServer dataServer;
	BillApproveServer approver;
	ChargeBillIDMaker idMaker;

	Inform_HallStaffInformServerImpl staffServer;
	HallStaffPO hallStaff;
	
	
	public ChargeBillServer(){
		this.dataServer=RMIHelper.getChargeBillData();
		approver=new BillApproverServerImpl();
		idMaker=new ChargeBillIDMaker();
		
		staffServer=new Inform_HallStaffInformServerImpl();
		hallStaff=staffServer.getStaff(SystemHelper.getUserID());
	}
	
	public ChargeBill makeBill(String date,String money,String senderNum,String senderName,Iterator<String> orderNumbers){

		ChargeBill bill=new ChargeBill(date, money, senderNum,senderName, orderNumbers);
		bill.setId(idMaker.giveId(bill));
		String HallID=hallStaff.getHall().getID();
		bill.setHallId(HallID);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		
		return bill;
	}
	
	public ChargeBill getBill(String id){
		ChargeBill bill=dataServer.findBill(id);
		return bill;
	}
	
	public ArrayList<ChargeBill> getBill(String date,String hallId){
		return dataServer.findBill(date, hallId);
	}

}
