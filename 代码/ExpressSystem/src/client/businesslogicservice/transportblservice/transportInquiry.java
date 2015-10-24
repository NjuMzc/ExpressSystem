package client.businesslogicservice.transportblservice;

import client.vo.BillVO;
import client.vo.GoodVO;

/**
 * 该接口提供运输过程中所有的查询服务
 * 包括
 * 货物物流状态查询
 * 订单查询
 * @author Ma
 *
 */

public interface transportInquiry {

	/*
	 * 通过货物编号获得货物信息
	 */
	public GoodVO GoodInquire(String id);
	
	
	/*
	 * 通过订单编号获得订单信息
	 */
	public BillVO Inquire(String id);
}
