package businesslogic.salarybl;

import po.salary.SalaryPO;
import po.salary.Salary_Type;
import po.salary.Staff_Type;
import client.RMIHelper;
import dataservice.salarydataservice.SalaryDataServer;
import vo.SalaryVO;
import businesslogicservice.salaryblservice.SalaryServer;

public class SalaryServerImpl implements SalaryServer{
	
	SalaryDataServer dataServer;
	
	public SalaryServerImpl(){
		this.dataServer=RMIHelper.getSalaryData();
	}

	@Override
	public SalaryVO getSalary(String type) {
		// TODO Auto-generated method stub
		SalaryPO salaryp = dataServer.getSalary(Staff_Type.valueOf(type));
		
		if(salaryp==null){
			SalaryVO salaryv=new SalaryVO("所查询的类型不符要求！");
			return salaryv;
		}
		else{
			SalaryVO salaryv=new SalaryVO(salaryp.getNum(), salaryp.getSalaryType().toString(),
					salaryp.getStaffType().toString());
			return salaryv;
		}
		
	}

	@Override
	public SalaryVO setSalary(SalaryVO salary) {
		// TODO Auto-generated method stub
		SalaryPO salaryp=new SalaryPO(Staff_Type.valueOf(salary.getStaffType()));
		salaryp.setNum(salary.getNum());
		salaryp.setSalaryType(Salary_Type.valueOf(salary.getSalaryType()));
		
		dataServer.update(salaryp);
		
		return salary;
	}

}
