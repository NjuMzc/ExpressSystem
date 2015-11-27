package po.Institution;

import java.util.ArrayList;

import po.Workers.HallStaffPO;

/**
 * 营业厅的PO对象
 * @author rabook
 *
 */
public class HallPO {
	private String id;//机构编号，格式为所在地编号3位+3位流水号
	
	private ArrayList<HallStaffPO> HallStaffList;
	
	public HallPO(String id){
		this.id=id;
		this.HallStaffList=new ArrayList<HallStaffPO>();
	}
	
	public void addHallStaff(HallStaffPO hall){
		HallStaffList.add(hall);
	}
	
	public void removeHallStaff(HallStaffPO hall){
		HallStaffList.remove(hall);
	}
	
	public String getID(){
		return id;
	}

}
