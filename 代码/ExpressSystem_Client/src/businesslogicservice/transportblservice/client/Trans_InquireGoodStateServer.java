package businesslogicservice.transportblservice.client;

import java.util.Iterator;

public interface Trans_InquireGoodStateServer {

	public String getGoodState(String id);
	
	public Iterator<String> getTrace(String id);
}
