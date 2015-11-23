package dataservice.transportdataservice;

import po.GoodPO;

/**
 * 运输模块的数据接口
 * 
 * @author nick
 *
 */
public interface transportDataServer {
	public void insert(GoodPO po);

	public void update(GoodPO po);

	public GoodPO find(String id);
}
