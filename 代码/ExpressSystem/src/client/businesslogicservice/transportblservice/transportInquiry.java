package client.businesslogicservice.transportblservice;

import client.po.BillPO;
import client.po.GoodPO;
import client.vo.BillVO;
import client.vo.GoodVO;

/**
 * 运输过程中的单据制作接口
 * @author Ma
 *
 */

public interface transportInquiry {


	public GoodPO GoodInquire(String id);
	
	
	public BillPO Inquire(String id);
	
}
