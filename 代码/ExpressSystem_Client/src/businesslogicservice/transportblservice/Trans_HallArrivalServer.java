package businesslogicservice.transportblservice;

/**
 * 营业厅到达单填写接口
 * 
 */
import po.bills.HallArrivalBill;

public interface Trans_HallArrivalServer {

	public HallArrivalBill makeBill(String date, String transOrderNum, String departure, String state);
}
