package po.bills;

import po.Message;

public class ImportBill{

    String number;
	String date;
	String aim;
	String[] location;
	
	
	public ImportBill(Message message) {
		// TODO Auto-generated constructor stub
		location=new String[4];
		this.number=message.getInform(0);
		this.date=message.getInform(1);
		this.aim=message.getInform(2);
		for(int i=0;i<4;i++){
			location[i]=message.getInform(i+3);
		}
	}
	
	public String getNumber() {
		return number;
	}


	public String getDate() {
		return date;
	}


	public String getAim() {
		return aim;
	}


	public String[] getLocation() {
		return location;
	}

}
