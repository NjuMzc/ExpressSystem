package client;

import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import presentation.MainFrame;

public class Client {

	public static void main(String[] args) {
		RMIHelper.init();
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

		} catch (Exception e) {
			// TODO exception
		}

		// 这个包只能在下面的线程里改变他的frame属性，不然会报错

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame m = new MainFrame();
				m.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				// m.setUndecorated(true);
				// 用来消除上面的属性栏

			}
		});

	}
	

}
