package businesslogicservice.transportblservice.client;

import java.util.ArrayList;

public interface Trans_InquireGoodStateServer {

	public String getGoodState(String id);
	
	public ArrayList<String> getTrace(String id);
}
