package businesslogicservice.accountSetblservice;

import java.util.Iterator;

import vo.accountSet.StorageSetterVO;

public interface storageSetter {

	public StorageSetterVO addInform(StorageSetterVO vo);
	
	public Iterator<StorageSetterVO> getInform();
}
