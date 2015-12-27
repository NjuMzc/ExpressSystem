package businesslogic.transportbl.courier;
/**
 * 制作订单功能的实现
 */
import po.Message;
import po.bills.OrderBill;
import vo.BillVO;
import businesslogic.billsbl.OrderBillServer.OrderBillServer;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.courier.Trans_MakingOrderServer;

public class Trans_MakingOrderServerImpl implements Trans_MakingOrderServer{
    
	OrderBillServer billServer;
	GoodController goodController;
	
	//需要RMI提供
	public Trans_MakingOrderServerImpl(){
		this.billServer=new OrderBillServer();
		this.goodController=new GoodController();
	}
	
	@Override
	public BillVO makeOrder(Message msg) {
		// TODO Auto-generated method stub
		BillVO result;
		
		try{
			double temp;
			temp=Double.valueOf(msg.getInform(4));
			temp=Double.valueOf(msg.getInform(11));
			temp=Double.valueOf(msg.getInform(5));
			temp=Double.valueOf(msg.getInform(6));
		}catch(NumberFormatException e){
			result=new BillVO("输入的数据格式有误!");
			return result;
		}
		
		
	    OrderBill bill=billServer.makeBill(msg);
	    if(bill==null){
	    	return null;
	    }
	    //还需要计算预计时间
	    {
	    	
	    }
	    
	    //添加一个新的货物
	    goodController.makeGood(bill);
	    
	    result=new BillVO();
	    result.setId(bill.getID());
	    result.setFee(bill.getCharge());
	    result.setDate(bill.getTime());
		return result;
	}

}
