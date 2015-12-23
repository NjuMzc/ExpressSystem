package businesslogicservice.paymentblservice;
/**
 * 獲得成本收益表
 */
import vo.paymentbl.ProfitVO;

public interface GetProfitServer {

	public  ProfitVO getProfit(String start,String end);
}
