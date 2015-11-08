package client.businesslogicservice.billsblservice;

import client.vo.*;

/**
 * 制作订单的接口
 * 返回BillVO是一个泛型的对象
 * @author rabook
 *
 */

public interface billMaker {

	public BillVO makeBill(Message message);
	
}
