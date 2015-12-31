package businesslogic.accountSetbl;

import java.util.Iterator;

import dataservice.accountsetdataservice.BankInformDataServer;
import vo.BankVO;
import businesslogicservice.accountSetblservice.bankSetter;
import businesslogicservice.bankblservice.bankServer;

public class BankSetterImpl implements bankSetter {

	BankInformDataServer dataServer;
	bankServer blServer;
	
	@Override
	public BankVO addInform(BankVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<BankVO> getInform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

}
