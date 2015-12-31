package po.accountSet;

public class BankInform {
	String name;
	String money;

	public BankInform(String name, String money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

}
