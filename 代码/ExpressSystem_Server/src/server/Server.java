package server;

public class Server {

	public static void main(String[] args) {
		// 这是联网分机
		// RMIHelper.init();
		// 这是本地测试用
		RMILocalHost.init();
	}

}
