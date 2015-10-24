package client.businesslogicservice.storageblservice;

import client.vo.BillVO;
import client.vo.Message;
import client.vo.StorageVO;


/**
 * 该接口提供仓库管理过程中的所有相关服务
 * 包括
 * 商品入库
 * 商品出库
 * 库存盘点
 * 库存查看
 * @author Ma
 *
 */
public interface storageServer {
	
	/*
	 * 该方法提供出库单与入库单的制作
	 */
	public BillVO storageBillsMake(Message message);
	
	/*
	 * 该方法提供库存盘点服务，返回当前的库存清单
	 */
	public StorageVO getStorageList();
	
	/*
	 * 该方法提供利用起始结束时间查看库存进出情况的服务
	 */
	public Message getStorageHistory(String startTim,String endTime);
	
	/*
	 * 该方法提供分区调整服务
	 */
	public Message changeStorage(String id,String newLocation);

}
