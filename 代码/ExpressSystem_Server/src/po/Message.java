package po;

import java.util.ArrayList;

/**
 * 用于界面层传递给逻辑层信息的类
 * @author rabook
 *
 */

public  class Message {
	
     private ArrayList informs=new ArrayList();
     
     public void addInform(String inform){
    	 informs.add(inform);
     }
     
     public String getInform(int number){
    	 return informs.get(number).toString();
     }
     
     public int length(){
    	 return informs.size();
     }
     
}
