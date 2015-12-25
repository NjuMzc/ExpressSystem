package presentation.right.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.omg.CORBA.FREE_MEM;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_make_constant extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;

	JLabel cityremind;
	JLabel city[];
	JLabel km[];
	JTextField jtf1[];
	JLabel feeremind;
	JLabel fee[];
	JLabel yuan[];
	JTextField jtf2[];
	JButton submit;
	JButton cancel;
	private List<Watcher> list;

	public Manager_make_constant(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		cityremind = new JLabel("城市距离:");
		cityremind.setFont(new Font("宋体", Font.BOLD, 20));

		city = new JLabel[6];
		km = new JLabel[6];
		jtf1 = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			city[i] = new JLabel();
			km[i] = new JLabel("km");
			jtf1[i] = new JTextField();
			city[i].setFont(new Font("宋体", Font.PLAIN, 16));
			km[i].setFont(new Font("宋体", Font.PLAIN, 16));
			jtf1[i].setFont(new Font("宋体", Font.PLAIN, 16));
		}

		feeremind = new JLabel("包装价格:");
		feeremind.setFont(new Font("宋体", Font.BOLD, 20));
		fee = new JLabel[3];
		yuan = new JLabel[3];
		jtf2 = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			fee[i] = new JLabel();
			yuan[i] = new JLabel("元");
			jtf2[i] = new JTextField();
			fee[i].setFont(new Font("宋体", Font.PLAIN, 16));
			yuan[i].setFont(new Font("宋体", Font.PLAIN, 16));
			jtf2[i].setFont(new Font("宋体", Font.PLAIN, 16));
		}
		submit = new JButton("");// 提交
		cancel = new JButton("");// 取消

		init();

		this.add(cityremind);
		this.add(feeremind);
		for (int i = 0; i < 6; i++) {
			this.add(city[i]);
			this.add(km[i]);
			this.add(jtf1[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(fee[i]);
			this.add(yuan[i]);
			this.add(jtf2[i]);
		}
		this.add(submit);
		this.add(cancel);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\制定常量right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		cityremind.setBounds(frameWidth / 10, frameHeight / 10 - frameHeight
				/ 20, frameWidth / 8, frameHeight / 10);
		feeremind.setBounds(frameWidth / 10,
				frameHeight / 2 + frameHeight / 10, frameWidth / 8,
				frameHeight / 10);
		city[0].setText("南京——北京");
		city[1].setText("北京——广州");
		city[2].setText("广州——上海");
		city[3].setText("上海——南京");
		city[4].setText("广州——北京");
		city[5].setText("上海——广州");
		fee[0].setText("木箱：");
		fee[1].setText("纸盒：");
		fee[2].setText("包装袋：");
		for (int i = 0; i < 3; i++) {
			city[i].setBounds(frameWidth / 10, frameHeight / 5 + frameHeight
					/ 10 * i - frameHeight / 20, frameWidth / 9,
					frameHeight / 20);
			km[i].setBounds(frameWidth / 20 * 7, frameHeight / 5 + frameHeight
					/ 10 * i - frameHeight / 20, frameWidth / 10,
					frameHeight / 20);
			fee[i].setBounds(frameWidth / 10 + frameWidth / 5 * i, frameHeight
					/ 2 + frameHeight / 5, frameWidth / 9, frameHeight / 20);
			yuan[i].setBounds(frameWidth / 10 + frameWidth / 8 + frameWidth / 5
					* i, frameHeight / 2 + frameHeight / 5, frameWidth / 20,
					frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 40 * 9, frameHeight / 5
					+ frameHeight / 10 * i - frameHeight / 20, frameWidth / 10,
					frameHeight / 20);
			jtf2[i].setBounds(frameWidth / 6 + frameWidth / 5 * i, frameHeight
					/ 2 + frameHeight / 5, frameWidth / 20, frameHeight / 20);
		}
		for (int i = 3; i < 6; i++) {
			city[i].setBounds(frameWidth / 12 * 5, frameHeight / 5
					+ frameHeight / 10 * (i - 3) - frameHeight / 20,
					frameWidth / 9, frameHeight / 20);
			km[i].setBounds(frameWidth / 12 * 5 + frameWidth / 4, frameHeight
					/ 5 - frameHeight / 20 + frameHeight / 10 * (i - 3),
					frameWidth / 10, frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 12 * 5 + frameWidth / 4 - frameWidth
					/ 8, frameHeight / 5 - frameHeight / 20 + frameHeight / 10
					* (i - 3), frameWidth / 10, frameHeight / 20);
		}
		for (int i = 0; i < 6; i++) {
			jtf1[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
		}
		for (int i = 0; i < 3; i++) {
			jtf2[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
		}

		submit.setBounds(frameWidth / 10 + frameHeight / 17, frameHeight / 10
				* 9 - frameHeight / 55, frameWidth / 10, frameHeight / 18);
		cancel.setBounds(frameWidth / 20 * 10, frameHeight / 10 * 9
				- frameHeight / 55, frameWidth / 10, frameHeight / 18);
		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//提交.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		submit.setIcon(icon2);

	}

	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

	public void actionPerformed(ActionEvent e) {
	}
}
