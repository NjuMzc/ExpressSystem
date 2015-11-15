package Mock_and_Driver;

import client.businesslogic.transportbl.transportInquiryImpl;
import client.po.BillPO;
import client.po.GoodPO;

public class MockTransportInquiry extends transportInquiryImpl {

	public GoodPO GoodInquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("Good is inquired!");
		return null;
	}

	public BillPO Inquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("Inquire!");
		return null;
	}
}
