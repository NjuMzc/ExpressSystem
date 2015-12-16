package businesslogic.paymentServer;

import vo.exception.ExceptionMessage;
import vo.paymentbl.SettleVO;
import businesslogic.billsbl.ChargeBillServer.ChargeBillServer;
import businesslogic.informationbl.Inform_HallInformServerImpl;
import businesslogicservice.informationblservice.InstitutionInform.Inform_HallInformServer;
import businesslogicservice.paymentblservice.SettleServer;

public class SettleServerImpl implements SettleServer {
	ChargeBillServer billServer;
	Inform_HallInformServer hallServer;

	public SettleServerImpl() {
		billServer = new ChargeBillServer();
		hallServer=new Inform_HallInformServerImpl();
	}

	@Override
	public SettleVO Settle(String date, String hallNum) {
		// TODO Auto-generated method stub
		if(hallServer.getHall(hallNum)==null){
			ExceptionMessage exMessage=new ExceptionMessage("输入的营业厅不存在！");
			SettleVO settle=new SettleVO(exMessage);
			return settle;
		}
		
		SettleVO settle=new SettleVO(billServer.getBill(date, hallNum));
		
		return settle;
	}

}
