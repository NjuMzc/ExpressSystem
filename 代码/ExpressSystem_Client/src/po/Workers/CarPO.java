package po.Workers;

import po.Institution.HallPO;

/**
 * 车辆的PO对象
 * @author rabook
 *
 */
public class CarPO {

	private String id;//车辆编号，营业厅编号6位+3位流水号
	
	private String ChePai;//车牌号
	
	private String UsingTime;//服役时间
	
	private HallPO hall;//所属营业厅
	
	public CarPO(String id){
		this.id=id;
	}
	
    //Setters and Getters	
	public String getChePai() {
		return ChePai;
	}

	public void setChePai(String chePai) {
		ChePai = chePai;
	}

	public String getUsingTime() {
		return UsingTime;
	}

	public void setUsingTime(String usingTime) {
		UsingTime = usingTime;
	}
	
	public void setHall(HallPO hall){
		this.hall=hall;
	}
	
	public HallPO getHall(){
		return hall;
	}
}
