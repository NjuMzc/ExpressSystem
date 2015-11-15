package Mock_and_Driver.bankbl;

import client.businesslogic.bankbl.Bank;

public class MockBank extends Bank{

	public MockBank(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
	}
	
	public MockBank(){
			this.name="software";
			this.balance=20.5;
	}
	
    private String name;
    private double balance;
    
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
