package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Iterator;

import vo.paymentbl.PayVO;

public class PaymentBill implements  Serializable,Remote{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7458849121566130285L;
	
	

	private String date;//付款日期
	private String payer;//付款人
	private String account;//付款账号
	private String tiaoMu;//付款条目
	private double money;//付款金额
	private String beiZhu;//备注
	
	private String id;//该单据id，付款日期8位+4位流水号
	private BillApproverPO billForApprover;

	
	public PaymentBill(String date,String payer,String account,String tiaoMu,String money,String beiZhu) {
		// TODO Auto-generated constructor stub
        this.date=date;
        this.payer=payer;
        this.account=account;
        this.tiaoMu=tiaoMu;
        this.money=Double.valueOf(money);
        this.beiZhu=beiZhu;
        
        this.id=date+"000";
        billForApprover=new BillApproverPO();
	}

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


	public double getMoney() {
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
    
	public BillApproverPO submit(){
		billForApprover.setState("Submit");
		
		billForApprover.setEaseInform(date, id, "收款单");
		
		billForApprover.addInform("付款单编号:"+id);
		billForApprover.addInform("付款日期:"+date);
		billForApprover.addInform("付款金额:"+money);
		billForApprover.addInform("付款账户:"+account);
		billForApprover.addInform("付款条目:"+tiaoMu);
		billForApprover.addInform("备注:"+beiZhu);

		return billForApprover;
	}
}
