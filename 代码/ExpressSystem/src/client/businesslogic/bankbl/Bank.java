package client.businesslogic.bankbl;

public class Bank {
     private String name;
     private double balance;
     
     public Bank(String name,double balance){
     	this.name=name;
     	this.balance=balance;
      }
     
     public Bank(){}
     
     public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
     
 
     
}
