package po.Institution.storageAssist;

import java.io.Serializable;

public class StoreList implements Serializable{
	String num;
	String date;
	String destination;
	String[] location;

	public StoreList(String num, String date, String destination,
			String[] location) {
		this.num = num;
		this.date = date;
		this.destination = destination;
		this.location = location;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}
}
