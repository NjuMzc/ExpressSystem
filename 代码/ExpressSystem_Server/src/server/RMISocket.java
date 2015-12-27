package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class RMISocket extends RMISocketFactory {

	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(host, port);
	}

	public ServerSocket createServerSocket(int port) throws IOException {
		if (port == 0)
			port = 8500;

		System.out.println("RMI服务器的注册与数据传输端口 =" + port);
		return new ServerSocket(port);
	}

}