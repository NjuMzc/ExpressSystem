package vo.storagebl;

import vo.exception.ExceptionMessage;

public class ExportVO {
	ExceptionMessage exMessage;
	
	String orderNum;// 快递编号
	String date;// 日期

	String destination;// 目的地
	String loader;// 装运方式
	String DeliverNum;// 中转单号
	String transportNum;// 汽运编号

	String id;// 该单据的id，同快递编号
	
	public ExportVO(){
		this.exMessage=new ExceptionMessage();
	}
	
	public ExportVO(String orderNum,String date,String destination,
			String loader,String DeliverNum,String transportNum){
		this.orderNum=orderNum;
		this.date=date;
		this.destination=destination;
		this.loader=loader;
		this.DeliverNum=DeliverNum;
		this.transportNum=transportNum;
		
		exMessage=new ExceptionMessage();
	}
	
	public ExportVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	//Setters and Getters
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getDeliverNum() {
		return DeliverNum;
	}

	public void setDeliverNum(String deliverNum) {
		DeliverNum = deliverNum;
	}

	public String getTransportNum() {
		return transportNum;
	}

	public void setTransportNum(String transportNum) {
		this.transportNum = transportNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	// 用于传递错误信息
	public boolean isWrong() {
		return exMessage.isWrong();
	}

	public String getWrongMessage() {
		return exMessage.getMessage();
	}
}
