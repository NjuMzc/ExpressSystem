package businesslogic.transportbl.client;

import java.util.ArrayList;
import java.util.Iterator;

import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.client.Trans_InquireGoodStateServer;

public class Trans_InquireGoodStateServerImpl implements
		Trans_InquireGoodStateServer {
	GoodController goodController;
	
	public Trans_InquireGoodStateServerImpl(){
		goodController=new GoodController();
	}
	

	@Override
	public String getGoodState(String id) {
		// TODO Auto-generated method stub
		String State=goodController.getGoodTransState(id);
		return State;
	}

	@Override
	public Iterator<String> getTrace(String id) {
		// TODO Auto-generated method stub
		ArrayList<String> trace=goodController.getGoodTrace(id);
		if(trace==null){
			return null;
		}
		return trace.iterator();
	}

}
