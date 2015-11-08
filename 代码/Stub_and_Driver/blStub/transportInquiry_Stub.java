package client.blStub;

import client.businesslogicservice.transportblservice.transportInquiry;
import client.vo.BillVO;
import client.vo.GoodVO;

public class transportInquiry_Stub implements transportInquiry {

	public GoodVO GoodInquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("Good is inquired");
		return null;
	}

	public BillVO Inquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("BillVO Inquire");
		return null;
	}

}
