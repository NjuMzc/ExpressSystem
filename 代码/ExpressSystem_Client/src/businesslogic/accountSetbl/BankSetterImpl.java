package businesslogic.accountSetbl;

import java.util.ArrayList;
import java.util.Iterator;

import client.RMIHelper;
import po.accountSet.BankInform;
import dataservice.accountsetdataservice.BankInformDataServer;
import vo.BankVO;
import businesslogic.bankbl.BankServerImpl;
import businesslogicservice.accountSetblservice.bankSetter;
import businesslogicservice.bankblservice.bankServer;

public class BankSetterImpl implements bankSetter {

	BankInformDataServer dataServer;
	bankServer blServer;
	
	public BankSetterImpl(){
		this.dataServer=RMIHelper.getBankInformData();
		blServer=new BankServerImpl();
	}
	
	@Override
	public BankVO addInform(BankVO vo) {
		// TODO Auto-generated method stub
		if(vo.getName().equals("")||vo.getMoney().equals("")){
			BankVO result=new BankVO("输入信息不完整请重新输入!");
			return result;
		}
		blServer.addBank(vo.getName(), vo.getMoney());
		BankInform inform=new BankInform(vo.getName(), vo.getMoney());
		dataServer.addInform(inform);
		
		return vo;
	}

	@Override
	public Iterator<BankVO> getInform() {
		// TODO Auto-generated method stub
		ArrayList<BankInform> list=dataServer.getInform();
		Iterator<BankInform> it=list.iterator();
		ArrayList<BankVO> volist=new ArrayList<>();
		
		while(it.hasNext()){
		    BankInform infor=it.next();
		    BankVO vo=new BankVO(infor.getName(), infor.getMoney());
		    volist.add(vo);
		
		}
		
		return volist.iterator();
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

}
