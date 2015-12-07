package po.salary;

import java.io.Serializable;
import java.rmi.Remote;

public class SalaryPO implements Serializable, Remote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2831099781192497047L;

	private Staff_Type staffType;
	private Salary_Type salaryType;
	private String num;

	public SalaryPO(Staff_Type type) {
		num = "";
		staffType = type;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Staff_Type getStaffType() {
		return staffType;
	}

	public Salary_Type getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(Salary_Type salaryType) {
		this.salaryType = salaryType;
	}

}
