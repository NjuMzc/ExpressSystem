package Mock_and_Driver.storagebl;

import po.Message;
import businesslogicservice.storageblservice.storageServer;

public class storageDriver {

	//Storage的辅助类的Mock没有完成。感觉重要性不是很大
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message=new Message();

		storageServer server=new MockStorageServerImpl();
		server.getGoodsList();
		server.makeImportBill(message);
		server.makeExportBill(message);
		server.getStorageHistory("1", "2");
	}

}
