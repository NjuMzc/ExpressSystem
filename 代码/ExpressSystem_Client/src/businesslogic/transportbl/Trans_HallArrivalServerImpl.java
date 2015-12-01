package businesslogic.transportbl;
/**
 * 营业厅到达单功能的实现
 * 尚未完成！！
 */
import po.bills.HallArrivalBill;
import businesslogic.billsbl.HallArrivalBillServer.HallArrivalBillServer;
import businesslogicservice.transportblservice.Trans_HallArrivalServer;

public class Trans_HallArrivalServerImpl implements Trans_HallArrivalServer {
	HallArrivalBillServer billServer;
	GoodController goodController;

	@Override
	public HallArrivalBill makeBill(String date, String transOrderNum,
			String departure, String state) {
		// TODO Auto-generated method stub
		HallArrivalBill bill=billServer.makeBill(date, transOrderNum, departure, state);
		//还需要更改货物的信息
		//待其他功能完成后再实现此功能
		
		
		return bill;
	}

}
