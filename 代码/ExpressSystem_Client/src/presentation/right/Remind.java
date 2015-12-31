package presentation.right;

import java.awt.Color;

import javax.swing.*;

import presentation.Data;

public class Remind extends JPanel implements Runnable {

	int frameWidth;
	int frameHeight;
	Data d;
	int loc_x;
	int loc_y;
	Thread t;

	public Remind(String remind) {
		d = new Data();
		frameWidth = d.getFrameWidth();
		frameHeight = d.getFrameHeight();
		this.setBackground(Color.green);
		this.setSize(frameWidth / 4 * 3, frameHeight / 10);

		loc_x = 0;
		loc_y = frameHeight;
		
		t=new Thread(this);
	}

	@Override
	public void run() {

		while (loc_y > frameHeight / 20 * 19) {
			loc_y --;
			this.setLocation(loc_x, loc_y);
			this.repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
