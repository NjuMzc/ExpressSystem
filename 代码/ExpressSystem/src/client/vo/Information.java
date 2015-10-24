package client.vo;

import java.util.ArrayList;

public  class Information {
	
     private ArrayList<String> informs=new ArrayList<String>();
	
     public void addInform(String inform){
    	 informs.add(inform);
     }
     
     public String getInform(int number){
    	 return informs.get(number);
     }
     
}
