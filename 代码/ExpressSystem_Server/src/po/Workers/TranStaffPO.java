package po.Workers;

import java.io.Serializable;
import java.rmi.Remote;

import po.Institution.TranStationPO;

public class TranStaffPO implements Serializable,Remote{
	private String name;//姓名,与系统名字相同
	private String id;//编号，与系统编号相同
	private TranStationPO station;//所属的营业厅
	
	public TranStaffPO(String name,String id,TranStationPO station){
		this.name=name;
		this.id=id;
		this.station=station;
	}
	
	//Setter and Getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId(){
		return id;
	}
	
	public TranStationPO getStation(){
		return station;
	}
	
	public void setStation(TranStationPO station){
		this.station=station;
	}
}
