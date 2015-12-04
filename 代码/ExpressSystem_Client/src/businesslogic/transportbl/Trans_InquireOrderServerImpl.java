package businesslogic.transportbl;
/**
 * 查询订单功能的实现
 */
import po.bills.OrderBill;
import businesslogic.billsbl.OrderBillServer.OrderBillServer;
import businesslogicservice.transportblservice.Trans_InquireOrderServer;

public class Trans_InquireOrderServerImpl implements Trans_InquireOrderServer {

	OrderBillServer billServer;
	
	public Trans_InquireOrderServerImpl(){
		billServer=new OrderBillServer();
	}
	@Override
	public OrderBill inquire(String id) {
		// TODO Auto-generated method stub
		OrderBill bill=billServer.findBill(id);
		if(bill!=null){
			return bill;
		}else
		{
			System.out.println("该订单不存在！");
			return null;
		}
	}

}
