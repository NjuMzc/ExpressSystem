package presentation.right;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.Data;
import presentation.watcher.State;

public class Remind extends Thread {

	JPanel remindJp;
	JLabel remindjL;
	Data d;
	int frameWidth;
	int frameHeight;
	int loc_x;
	int loc_y;

	public Remind(JPanel jp, String input) {
		d = new Data();
		frameWidth = d.getFrameWidth();
		frameHeight = d.getFrameHeight();
		remindJp = jp;
		remindjL = new JLabel(input);
		remindjL.setFont(new Font("宋体", Font.BOLD, 20));
//		remindJp.setBackground(new Color(174, 221, 129));
		remindJp.setBackground(new Color(237, 222, 139));
		remindJp.setLayout(null);
		remindjL.setBounds(frameWidth / 8, 0, frameWidth / 2, frameHeight / 10);
		remindJp.add(remindjL);

		loc_x = 0;
		loc_y = frameHeight;
	}

	@Override
	public void run() {
		super.run();

		while (loc_y >= frameHeight / 80 * 75) {

			loc_y--;
			remindJp.setBounds(loc_x, loc_y, frameWidth / 4 * 3,
					frameHeight / 10);
			remindJp.setVisible(true);
			try {
				Thread.sleep(2);
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

		while (loc_y <= frameHeight) {
			System.out.println("loc_y=" + loc_y);

			loc_y++;
			remindJp.setBounds(loc_x, loc_y, frameWidth / 4 * 3,
					frameHeight / 2);
			remindJp.setVisible(true);
			try {
				Thread.sleep(2);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
 
	}

}
