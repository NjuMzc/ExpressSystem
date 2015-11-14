package client.businesslogicservice.bankblservice;

import client.vo.BankVO;
import client.vo.Message;

/**
 * �ýӿ��ṩ�˻��������ط���
 * ����
 * �����˻�����ɾ�Ĳ�
 * @author rabook
 *
 */

public interface bankServer {
	
	public BankVO addBank(String name,double balance);
	
	public boolean removeBank(String name);
	
	public void changeBank(String name,Message message);
	
	public BankVO inquireBank(String name);
	
	public void update(String name,double payment);

}
