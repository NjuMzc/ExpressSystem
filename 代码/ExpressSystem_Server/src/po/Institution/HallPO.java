package po.Institution;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import po.Workers.CarPO;
import po.Workers.DriverPO;
import po.Workers.HallStaffPO;

/**
 * 营业厅的PO对象
 * 
 * @author rabook
 *
 */
public class HallPO implements Remote, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3106957535920594004L;
	private String id;// 机构编号，格式为所在地编号3位+3位流水号
	private String name;//该机构的名字

	private ArrayList<HallStaffPO> HallStaffList;
	private ArrayList<DriverPO> DriverList;
	private ArrayList<CarPO> CarList;

	public HallPO(String id) {
		this.id = id;
		this.HallStaffList = new ArrayList<HallStaffPO>();
		this.name="默认营业厅";
	}

	public void addHallStaff(HallStaffPO hall) {
		HallStaffList.add(hall);
	}

	public void removeHallStaff(HallStaffPO hall) {
		HallStaffList.remove(hall);
	}

	public String getID() {
		return id;
	}

	public ArrayList<HallStaffPO> getAllStaff(){
		return HallStaffList;
	}
	
	public void addDriver(DriverPO driver){
		DriverList.add(driver);
	}
	
	public void removeDriver(DriverPO driver){
		DriverList.remove(driver);
	}
	
	public ArrayList<DriverPO> getAllDriver(){
		return DriverList;
	}
	
	public void addCar(CarPO car){
		CarList.add(car);
	}
	
	public void removeCar(CarPO car){
		CarList.remove(car);
	}
	
	public ArrayList<CarPO> getAllCar(){
		return CarList;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
