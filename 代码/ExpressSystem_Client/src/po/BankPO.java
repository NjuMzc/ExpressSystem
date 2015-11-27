package po;

import java.io.Serializable;
import java.rmi.Remote;

public class BankPO implements Remote, Serializable{
	private String id;
	private double balance;
	
	public BankPO(String id,double balance){
		this.id=id;
		this.balance=balance;
	}
	
	public String getid(){
		return id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setid(String newid){
		this.id=newid;
	}
	
	public void setBalance(double newBalance){
		this.balance=newBalance;
	}
}
