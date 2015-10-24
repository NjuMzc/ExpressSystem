package client.businesslogicservice.paymentblservice;

import client.vo.BillVO;
import client.vo.Message;

/**
 * 该接口提供关于财务方面的服务
 * 包括
 * 新建收款单
 * 新建付款单（成本管理）
 * 查看成本收益表与经营情况表并可以导出
 * @author rabook
 *
 */
public interface paymentServer {
	
	/*
	 * 单据建立
	 */
	public BillVO paymentBillsMake(Message message);
	
	/*
	 * 经营情况表
	 */
	public Message getPaymentHistory(String start,String end);
	
	/*
	 * 成本收益表
	 */
	public Message getEarning();
	
	/*
	 * 导出表格
	 */
	public void export(Message message);

}
