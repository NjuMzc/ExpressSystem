package po;
/**
 * 城市的po对象
 * @author rabook
 *
 */
public class CityPO {

	private String name;//中文名字
	
	private String id;//区号
	
	public CityPO(String id,String name){
		this.id=id;
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}
	
}
