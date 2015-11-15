package client.businesslogicservice.paymentblservice;

import client.po.BillPO;
import client.vo.BillVO;
import client.vo.Message;

/**
 * �ýӿ��ṩ���ڲ�����ķ���
 * ����
 * �½��տ
 * �½�������ɱ�����
 * �鿴�ɱ�������뾭Ӫ��������Ե���
 * @author rabook
 *
 */
public interface paymentServer {
	
	/*
	 * ���ݽ���
	 */
	public BillPO makePaymentBills(Message message);
	
	public BillPO makeChargeBill(Message message);
	/*
	 * ��Ӫ�����
	 */
	public Message getPaymentHistory(String start,String end);
	
	/*
	 * �ɱ������
	 */
	public Message getEarning();
	
	/*
	 * �������
	 */
	public void export(Message message);

}
