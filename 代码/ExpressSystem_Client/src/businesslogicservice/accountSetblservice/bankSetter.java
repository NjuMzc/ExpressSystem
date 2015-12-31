package businesslogicservice.accountSetblservice;

import java.util.Iterator;

import vo.BankVO;

public interface bankSetter {
	public BankVO addInform(BankVO vo);
	
	public Iterator<BankVO> getInform();
	
	public void clean();//建账前先clean
}
