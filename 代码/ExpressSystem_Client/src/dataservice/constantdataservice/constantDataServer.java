package dataservice.constantdataservice;

import po.ConstantPO;
import po.Message;

public interface constantDataServer {
    public ConstantPO find(String id);

    public void delete(ConstantPO po);
    
    public void insert(ConstantPO po);
    
    public void update(ConstantPO po);
}
