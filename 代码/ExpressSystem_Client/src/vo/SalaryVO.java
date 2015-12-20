package vo;

import po.salary.Salary_Type;
import po.salary.Staff_Type;
import vo.exception.ExceptionMessage;

/**
 * 薪水的VO对象
 * @author rabook
 *
 */
public class SalaryVO {

	private Staff_Type staffType;
	private Salary_Type salaryType;
	private String num;
	
	private ExceptionMessage exMessage;

	public SalaryVO(String num,String salaryType,String staffType) {
		this.num = num;
		this.staffType = Staff_Type.valueOf(staffType);
		this.salaryType=Salary_Type.valueOf(salaryType);
		
		exMessage=new ExceptionMessage();
		
	}
	
	public SalaryVO(String exMessage){
		this.exMessage=new ExceptionMessage(exMessage);
	}

	public String getNum() {
		return num;
	}


	public String getStaffType() {
		return staffType.toString();
	}

	public String getSalaryType() {
		return salaryType.toString();
	}

	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}

}
