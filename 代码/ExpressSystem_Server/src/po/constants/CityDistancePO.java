package po.constants;

public class CityDistancePO {

	String city1;
	String city2;
	
	double distance;
	
	public CityDistancePO(String city1,String city2,double distance){
		this.city1=city1;
		this.city2=city2;
		this.distance=distance;
		
	}
	
	public double getDistance(){
		return distance;
	}
	
	public void setDistance(String distance){
		this.distance=Double.valueOf(distance);
	}
	
	/**
	 * 这个方法通过输入的城市判断是否是指的该对象
	 * 城市前后不影响结果
	 * @param city1
	 * @param city2
	 * @return
	 */
	public boolean isThis(String city1,String city2){
		if((this.city1.equals(city1)&&this.city2.equals(city2))
				||(this.city1.equals(city2)&&this.city2.equals(city1))){
			return true;
		}else
			return false;
	}
}
