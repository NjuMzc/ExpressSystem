package client.dataservice.paymentdataservice;

import client.po.PaymentPO;
import client.vo.Message;

public interface paymentdataserver {
	public Message find(String id);
	
	public void insert(PaymentPO po);
	
	public void init();
	
	public void finish();

}
