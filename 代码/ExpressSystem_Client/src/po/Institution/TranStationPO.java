package po.Institution;

import java.util.ArrayList;

import po.Workers.TranStaffPO;

/**
 * 中转中心对象
 * @author rabook
 *
 */
public class TranStationPO {

	private String id;//中转中心编号，格式为 地区编号3位
	private String name;//机构名称
	private ArrayList<TranStaffPO> staffList;//中转中心业务员列表
	private StoragePO storage;//该中转中心所具有的仓库
	
	public TranStationPO(String id,String name){
		this.id=id;
		this.name=name;
		staffList=new ArrayList<TranStaffPO>();
		storage=new StoragePO(id);
		
	}
	
	//Setter and Getter
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
    public StoragePO getStorage(){
    	return storage;
    }
    
    public ArrayList<TranStaffPO> getAllStaff(){
    	return staffList;
    }
	
    //增删人员
    public void addStaff(TranStaffPO staff){
    	staffList.add(staff);
    }
    
    public boolean removeStaff(TranStaffPO staff){
    	return staffList.remove(staff);
    }
	
}
