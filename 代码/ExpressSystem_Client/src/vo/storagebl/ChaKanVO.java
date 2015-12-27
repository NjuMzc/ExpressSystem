package vo.storagebl;

import java.util.ArrayList;
import java.util.Iterator;

import vo.exception.ExceptionMessage;

public class ChaKanVO {
	ExceptionMessage exMessage;
	
	ArrayList<RecordVO> list;
	
	
	public ChaKanVO(ArrayList<RecordVO> records){
		this.list=records;
		exMessage=new ExceptionMessage();
	}
	
	public ChaKanVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
		list=new ArrayList<>();
	}
	
	public Iterator<RecordVO> getList(){
		return list.iterator();
	}
	
	// 用于传递错误信息
	public boolean isWrong() {
		return exMessage.isWrong();
	}

	public String getWrongMessage() {
		return exMessage.getMessage();
	}
	
	
}
