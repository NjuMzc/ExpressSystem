package po.bills;

public class ImportBill{

	String orderNum;//快递编号
    String date;//入库日期
    String destination;//目的地
    String[] location;//位置信息
    
    String id;//该单据的id，同OrderNum
    
    public ImportBill(String orderNum,String date,String destination,String[] location){
    	this.orderNum=orderNum;
    	this.date=date;
    	this.destination=destination;
    	this.location=new String[4];
    	this.location=location;
    	
    	this.id=orderNum;
    }
    

    //Getter
    public String getOrderNum() {
		return orderNum;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String[] getLocation() {
		return location;
	}

	public String getId() {
		return id;
	}

}
