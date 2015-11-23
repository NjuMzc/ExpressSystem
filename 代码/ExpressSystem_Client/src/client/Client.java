package client;

import presentation.MainFrame;

public class Client {

	public static void main(String[] args) {
		RMIHelper.init();
		MainFrame m = new MainFrame();
	}

}
