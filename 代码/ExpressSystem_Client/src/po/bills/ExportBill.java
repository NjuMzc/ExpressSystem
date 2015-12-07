package po.bills;

public class ExportBill {
	
	String orderNum;//快递编号
	String date;//日期
	String destination;//目的地
	String loader;//装运方式
	String DeliverNum;//中转单号
	String transportNum;//汽运编号
	
	String id;//该单据的id，同快递编号
	BillApproverPO billForApprove;
	

	public ExportBill(String orderNum,String date,String destination,String loader,
			String DeliveryNum,String transportNum) {

		// TODO Auto-generated constructor stub
		this.orderNum=orderNum;
		this.date=date;
		this.destination=destination;
		this.loader=loader;
		this.DeliverNum=DeliveryNum;
		this.transportNum=transportNum;
		
		this.id=orderNum;
	
		billForApprove=new BillApproverPO();
	}
	
	public String getNumber() {
		return orderNum;
	}


	public String getDate() {
		return date;
	}


	public String getAim() {
		return destination;
	}


	public String getLoader() {
		return loader;
	}


	public String getDeliverNum() {
		return DeliverNum;
	}


	public String getTransportNum() {
		return transportNum;
	}

	public BillApproverPO submit(){
		
		
		return billForApprove;
	}
}
