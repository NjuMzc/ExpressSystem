package businesslogicservice.paymentblservice;

import vo.paymentbl.ChargeVO;

public interface ChargeServer {

	public ChargeVO makeBill(ChargeVO charge);
}
