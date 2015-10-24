package client.businesslogicservice.billsblservice;

import client.vo.*;

/**
 * 该接口提供所有单据创建的服务
 * @author Ma
 *
 */

public interface billMaker {

	public BillVO makeBill(Message message);
	
}
