package po.bills;

import java.io.Serializable;
import java.rmi.Remote;

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

	
	public PaymentBill(PayVO payInform) {
		// TODO Auto-generated constructor stub
        this.date=payInform.getDate();
        this.payer=payInform.getPayer();
        this.account=payInform.getAccount();
        this.tiaoMu=payInform.getTiaoMu();
        this.money=Double.valueOf(payInform.getMoney());
        this.beiZhu=payInform.getBeiZhu();
        
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
		return billForApprover;
	}
}
