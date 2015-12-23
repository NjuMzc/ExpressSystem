package vo.paymentbl;

public class ProfitVO {

	private double input;//收益

	private double output;//支出
	
	private double profit;//利润
	
	public ProfitVO(double input,double output){
		this.input=input;
		this.output=output;
		this.profit=input-output;
	}
	
	//Setters and Getters
	
	public double getInput() {
		return input;
	}

	public void setInput(double input) {
		this.input = input;
	}

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
}
