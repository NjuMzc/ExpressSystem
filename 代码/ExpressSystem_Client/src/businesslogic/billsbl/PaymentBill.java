package businesslogic.billsbl;

import po.BillPO;
import po.Message;

public class PaymentBill extends BillPO {

	private String date;//付款日期
	private double payment;//付款金额
	private String payer;//付款人
	private String account;//付款账号
	private double rent;//租金
	private double charge;//运费
	private double wages;//工资
	private double  reward;//奖励
	private Remark remark;//备注
	private String kind;

	
	public PaymentBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
		this.date=billInfor.getInform(0);
		this.payment=Double.parseDouble(billInfor.getInform(1));
		this.payer=billInfor.getInform(2);
		this.account=billInfor.getInform(3);
		this.rent=Double.parseDouble(billInfor.getInform(4));
		this.charge=Double.parseDouble(billInfor.getInform(5));
		this.wages=Double.parseDouble(billInfor.getInform(6));
		this.reward=Double.parseDouble(billInfor.getInform(7));
		this.remark.rentYear=Integer.parseInt(billInfor.getInform(8));
		this.remark.orderNum=billInfor.getInform(9);
		this.remark.wageMonth=Integer.parseInt(billInfor.getInform(10));
		this.remark.senderReward=Double.parseDouble(billInfor.getInform(11));
        this.kind=billInfor.getInform(12);
		
	}

    class Remark{
                  int rentYear;
                  String orderNum;
                   int wageMonth;
                   double senderReward;
 }
    
    //以下是各类get方法
    
    public String getDate(){
    	return date;
    }
    
    public double getPayment(){
    	return payment;
    }
    
    public String getPayer(){
    	return payer;
    }
    
    public String getAccount(){
    	return account;
    }
    
    public double getRent(){
    	return rent;
    }
    
    public double getCharge(){
    	return charge;
    }
    
    public double getWages(){
    	return wages;
    }
    
    public double reward(){
    	return reward;
    }
    
    public Remark getRemark(){
    		return remark;
    }
    
//    enum Kind{
//    	SENDER,DRIVER,SALESMAN
//    }
}
