package po.Workers;
import java.io.Serializable;
import java.rmi.Remote;


/**
 * 司机的PO对象
 */
import po.Institution.HallPO;

public class DriverPO implements Remote, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 777488687470027279L;

	private String name;//姓名
	
	private String id;//编号：营业厅编号6位+3位流水号
	
	private String birth;//出生日期，形如：1996-08-30
	
	private String ShenFenZheng;//身份证号
	
	private String mobileNum;//手机号
	
	private String sex;//性别
	
	private String portTime;//行驶证期限，同日期基本格式
	
	private HallPO hall;//所在的营业厅
	
	public DriverPO(String id,String name, String birth, String ShenFenZheng,
			String mobile, String sex, String portTime){
		this.id=id;
		this.name=name;
		this.birth=birth;
		this.ShenFenZheng=ShenFenZheng;
		this.mobileNum=mobile;
		this.sex=sex;
		this.portTime=portTime;
	}
	
	
	//Setters and Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getShenFenZheng() {
		return ShenFenZheng;
	}

	public void setShenFenZheng(String shenFenZheng) {
		ShenFenZheng = shenFenZheng;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPortTime() {
		return portTime;
	}

	public void setPortTime(String portTime) {
		this.portTime = portTime;
	}

	public void setHall(HallPO hall){
		this.hall=hall;
	}
	
	public HallPO getHall(){
		return hall;
	}
}
