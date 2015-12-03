
package dataservice.informationdataservice;

import java.rmi.Remote;

/**
 * 营业厅信息数据层交互接口
 * 增删改查
 */
import po.Institution.HallPO;

public interface Inform_HallDataServer extends Remote {

	public void addHall(HallPO hall);

	public HallPO find(String id);

	public void deleteHall(HallPO hall);

	public void updateHall(HallPO hall);

}
