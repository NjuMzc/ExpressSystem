package presentation.right.courier;

import po.bills.OrderBill;

public class BillNow {

	public static OrderBill bill;
	
	public static void setBill(OrderBill billIn){
		bill=billIn;
	}
	
	public static OrderBill getBill(){
		return bill;
	}
}
