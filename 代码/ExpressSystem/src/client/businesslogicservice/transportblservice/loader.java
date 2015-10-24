package client.businesslogicservice.transportblservice;

import client.vo.Bill;
import client.vo.Message;

public interface loader {
      public Bill load(Message message);
}
