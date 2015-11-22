package businesslogicservice.transportblservice;

import po.BillPO;
import po.GoodPO;
import vo.BillVO;
import vo.GoodVO;

/**
 * 运输过程中的单据制作接口
 * @author Ma
 *
 */

public interface transportInquiry {


	public GoodPO GoodInquire(String id);
	
	
	public BillPO Inquire(String id);
	
}
