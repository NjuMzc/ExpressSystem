package client.blDriver;

import client.businesslogicservice.transportblservice.transportBillsMaker;
import client.businesslogicservice.transportblservice.transportInquiry;
import client.vo.Message;

public class transportblservice_Driver {
	public void dive(transportBillsMaker transportbillsmaker,transportInquiry transportinquiry,Message messsage){
		transportbillsmaker.makeTransBill(messsage);
		transportinquiry.GoodInquire("11");
		transportinquiry.Inquire("12");
	}

}
