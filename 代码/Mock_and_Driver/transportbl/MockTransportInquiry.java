package Mock_and_Driver.transportbl;

import po.BillPO;
import po.GoodPO;
import businesslogic.transportbl.transportInquiryImpl;

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
