package client.dataservice.constantdataservice;

import client.po.ConstantPO;
import client.vo.Message;

public interface constantDataServer {
    public ConstantPO find(String id);

    public void delete(ConstantPO po);
    
    public void insert(ConstantPO po);
    
    public void update(ConstantPO po);
}
