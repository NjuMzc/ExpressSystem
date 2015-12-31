package presentation.right;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.Data;

public class Remind extends Thread {

	JPanel remindJp;
	Data d;
	int frameWidth;
	int frameHeight;
	int loc_x;
	int loc_y;

	public Remind(JPanel jp) {
		this.remindJp = jp;
		remindJp.setBackground(new Color(174, 221, 129));
		d = new Data();
		frameWidth = d.getFrameWidth();
		frameHeight = d.getFrameHeight();

		loc_x = 0;
		loc_y = frameHeight;
	}

	@Override
	public void run() {
		super.run();

		while (loc_y >= frameHeight / 80 * 75) {
			System.out.println("loc_y=" + loc_y);

			loc_y--;
			remindJp.setBounds(loc_x, loc_y, frameWidth / 4 * 3,
					frameHeight / 10);
			remindJp.setVisible(true);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
 
	}

}
