package client.businesslogicservice.transportblservice;

import client.vo.BillVO;
import client.vo.Message;

/**
 * 该接口用于关于运输流程中所有和新建单据有关的服务
 * 它的实现将会依赖于billbl中的工厂各种工厂
 * 接口的实现将新建单据和进行货物状态的更新
 * @author Ma
 *
 */

public interface transportBillsMaker {
	
	public BillVO makeTransBill(Message message);

}
