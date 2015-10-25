package client.dataservice.bankdataservice;

import client.po.BankPO;

public interface bankdataserver {
      public BankPO find(String id);
      
      public void insert(BankPO po);
      
      public void delete(BankPO po);
      
      public void update(BankPO po);
      
      public void init();
      
      public void finish();
      
      
      
}
