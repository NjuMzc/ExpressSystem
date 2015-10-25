package client.dataservice.billsdataservice;

import client.po.BillPO;

/**
 * 该接口提供利用单据编号查询单据的数据层服务
 * @author nick
 *
 */
public interface billFinder {

	public BillPO findBill(String id);
}
