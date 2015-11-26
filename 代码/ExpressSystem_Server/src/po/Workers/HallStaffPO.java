package po.Workers;

import po.Institution.HallPO;

/**
 * 营业厅业务员的PO对象
 * @author rabook
 *
 */
public class HallStaffPO {

	private String name;//姓名
	private String id;//编号，与系统编号相同
	
	private HallPO hall;//所属的营业厅
	

	public HallStaffPO(String id,String name,HallPO hall){
		this.id=id;
		this.name=name;
		this.hall=hall;
		
	}
	
	//Setter and Getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HallPO getHall() {
		return hall;
	}

	public void setHall(HallPO hall) {
		this.hall = hall;
	}

}
