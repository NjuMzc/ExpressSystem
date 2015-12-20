package businesslogicservice.transportblservice.tranStaff;

import po.bills.TransArrivalBill;

public interface Trans_TransArrivalServer {

	public TransArrivalBill makeBill(String tranStationID,String GoodID,String date, String transOrderNum, String departure, String state);
}
