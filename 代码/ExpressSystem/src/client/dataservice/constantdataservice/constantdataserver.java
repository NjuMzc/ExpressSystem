package client.dataservice.constantdataservice;

import client.po.ConstantPO;
import client.vo.Message;

public interface constantDataServer {
    public ConstantPO find(Message message);

    public ConstantPO delete(ConstantPO po);
    
    public void insert(ConstantPO po);
}
