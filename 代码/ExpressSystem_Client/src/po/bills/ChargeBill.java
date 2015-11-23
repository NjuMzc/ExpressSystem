package po.bills;

import businesslogicservice.billsblservice.Approvabale;
import po.BillPO;
import po.Message;

public class ChargeBill implements Approvabale{

private String senderNum;//快递员编号
private  String orderNum;//托运订单条形码号
private  double payment;//根据两地距离自动生成待完善
private String date;

	public ChargeBill(Message billInfor) {
		// TODO Auto-generated constructor stub
		this.senderNum=billInfor.getInform(0);
		this.orderNum=billInfor.getInform(1);
		this.payment=Double.parseDouble(billInfor.getInform(2));
		this.date=billInfor.getInform(3);
	}
//以下是各种get方法
	public  String getSenderNum(){
		return senderNum;
	}
	
	public String getOrderNum(){
			return orderNum;
    }
	
	public double getPayment(){
		return payment;
	}
	
	public String getDate(){
		return date;
	}
	
	//实现Approvabale接口
	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setState(String newState) {
		// TODO Auto-generated method stub
		
	}
}