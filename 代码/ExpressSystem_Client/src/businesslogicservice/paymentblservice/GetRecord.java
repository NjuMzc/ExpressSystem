package businesslogicservice.paymentblservice;

import vo.paymentbl.RecordVO;

public interface GetRecord {
       
	public RecordVO getRecord(String start,String end);
}
