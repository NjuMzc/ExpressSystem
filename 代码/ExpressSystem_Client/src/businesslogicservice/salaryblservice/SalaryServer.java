package businesslogicservice.salaryblservice;

import vo.SalaryVO;

public interface SalaryServer {

	public SalaryVO getSalary(String type);
	
	public SalaryVO setSalary(SalaryVO salary);
}
