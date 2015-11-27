package po;

import java.util.ArrayList;

/**
 * 用于界面层传递给逻辑层信息的类
 * @author rabook
 *
 */

public  class Message {
	
     private ArrayList<String> informs=new ArrayList<String>();
     
     public void addInform(String inform){
    	 informs.add(inform);
     }
     
     public String getInform(int number){
    	 return informs.get(number);
     }
     
     public int length(){
    	 return informs.size();
     }
     
}
