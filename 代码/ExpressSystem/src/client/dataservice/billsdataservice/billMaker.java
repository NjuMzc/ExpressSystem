package client.dataservice.billsdataservice;

import client.po.BillPO;
import client.vo.Message;

/**
 * 该接口提供所有单据创建的数据层服务
 * @author nick
 *
 */
public interface billMaker {

	public BillPO makeBill(Message message);
	
}

