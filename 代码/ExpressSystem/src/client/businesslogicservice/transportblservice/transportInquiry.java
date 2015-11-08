package client.businesslogicservice.transportblservice;

import client.vo.BillVO;
import client.vo.GoodVO;

/**
 * �ýӿ��ṩ������������еĲ�ѯ����
 * ����
 * ��������״̬��ѯ
 * ������ѯ
 * @author Ma
 *
 */

public interface transportInquiry {


	public GoodVO GoodInquire(String id);
	
	
	public BillVO Inquire(String id);
	
}
