package presentation;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Data {
	private int frameWidth;
	private int frameHeight;

	public Data() {
		adaptscreen();
	}

	private void adaptscreen() {
		// 获取屏幕大小
		int screenWidth;
		int screenHeight;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		if (screenWidth * 3 > screenHeight * 4) {
			this.frameHeight = screenHeight * 13 / 15;
			this.frameWidth = frameHeight * 4 / 3;
		} else {
			this.frameWidth = screenWidth;
			this.frameHeight = frameWidth * 3 / 4;
		}
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

}
