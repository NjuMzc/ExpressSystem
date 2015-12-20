package vo.paymentbl;

import po.bills.PaymentBill;
import vo.exception.ExceptionMessage;

public class PayVO {

	private String date;//付款日期
	private String payer;//付款人
	private String account;//付款账号
	private String tiaoMu;//付款条目
	private String money;//付款金额
	private String beiZhu;//备注
	
	private String id;//该单据id，付款日期8位+4位流水号
	private ExceptionMessage exMessage;//错误信息

    
	public PayVO() {
        exMessage=new ExceptionMessage();
	}
	
	public PayVO(PaymentBill bill){
	    this.date=bill.getDate();
	    this.payer=bill.getPayer();
	    this.account=bill.getAccount();
	    this.tiaoMu=bill.getTiaoMu();
	    this.money=String.valueOf(bill.getMoney());
	    this.beiZhu=bill.getBeiZhu();
	    this.id=bill.getId();
	    
	    this.exMessage=new ExceptionMessage();
	}
	
	public PayVO(ExceptionMessage exMessage){
		this.exMessage=exMessage;
	}

	
	//Setter and Getter
	public String getDate() {
		return date;
	}


	public String getPayer() {
		return payer;
	}


	public String getAccount() {
		return account;
	}


	public String getTiaoMu() {
		return tiaoMu;
	}


	public String getMoney() {
		return money;
	}


	public String getBeiZhu() {
		return beiZhu;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setTiaoMu(String tiaoMu) {
		this.tiaoMu = tiaoMu;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}

	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}
}
