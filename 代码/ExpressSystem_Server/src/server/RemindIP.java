package server;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RemindIP extends Thread {

	JPanel remindJp;
	JLabel remindjL;

	int frameWidth = 300;
	int frameHeight = 100;
	int loc_x;
	int loc_y;

	public RemindIP(JPanel jp, String input) {

		remindJp = jp;
		remindjL = new JLabel(input);
		remindjL.setFont(new Font("宋体", Font.BOLD, 20));
		remindJp.setBackground(new Color(174, 221, 129));
		remindJp.setLayout(null);
		remindjL.setBounds(75, 0, 150, 100);
		remindJp.add(remindjL);

		loc_x = 0;
		loc_y = 500;
	}

	@Override
	public void run() {
		super.run();

		while (loc_y >= 375) {

			System.out.println(loc_y);

			loc_y--;
			remindJp.setBounds(loc_x, loc_y, 300, 100);
			remindJp.setVisible(true);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (loc_y <= 500) {
			loc_y++;
			remindJp.setBounds(loc_x, loc_y, 300, 100);
			remindJp.setVisible(true);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
