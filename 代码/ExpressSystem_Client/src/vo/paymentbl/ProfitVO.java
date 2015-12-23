package vo.paymentbl;

import vo.exception.ExceptionMessage;

public class ProfitVO {

	private double input;//收益

	private double output;//支出
	
	private double profit;//利润
	
	ExceptionMessage exMessage;
	
	public ProfitVO(double input,double output){
		this.input=input;
		this.output=output;
		this.profit=input-output;
		
		this.exMessage=new ExceptionMessage();
	}
	
	public ProfitVO(String exMessage){
		this.exMessage=new ExceptionMessage(exMessage);
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
	
	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}
}
