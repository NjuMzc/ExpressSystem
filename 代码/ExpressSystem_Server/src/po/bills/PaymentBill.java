package po.bills;

import java.io.Serializable;
import java.rmi.Remote;

import po.Message;

public class PaymentBill implements  Serializable,Remote{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7458849121566130285L;
	private String id;//该单据id

	
	public PaymentBill(Message billInfor) {
		// TODO Auto-generated constructor stub

		
	}

    
	public void setId(String id){
		this.id=id;
	}
	
	public String getId(){
		return id;
	}
    
}
