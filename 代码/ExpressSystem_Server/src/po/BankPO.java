package po;

public class BankPO {
	private String name;
	private double balance;
	
	public BankPO(String name,double balance){
		this.name=name;
		this.balance=balance;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setName(String newName){
		this.name=newName;
	}
	
	public void setBalance(double newBalance){
		this.balance=newBalance;
	}
}
