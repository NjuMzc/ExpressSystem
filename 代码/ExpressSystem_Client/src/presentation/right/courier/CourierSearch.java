package presentation.right.courier;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;

import businesslogic.transportbl.courier.Trans_InquireOrderServerImpl;
import businesslogicservice.transportblservice.courier.Trans_InquireOrderServer;
import po.bills.OrderBill;
import presentation.Data;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CourierSearch extends RightAll implements ActionListener {
	Trans_InquireOrderServer blServer;

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton confirm;
	JButton cancel;
	JTextField inputOrder;
	boolean isWrongShow = false;
	private List<Watcher> list;

	JPanel jp_wrong;
	String input_wrong;
	Remind remindThread;

	public CourierSearch(int frameWidth, int frameHeight) {
		blServer = new Trans_InquireOrderServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel("");// 请输入快递单号
		confirm = new JButton("");// 确认
		cancel = new JButton("");// 取消
		inputOrder = new JTextField();

		init();

		this.add(remind);
		this.add(confirm);
		this.add(cancel);
		this.add(inputOrder);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\查询订单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		remind.setBounds(frameWidth / 4, frameHeight / 3, frameWidth / 4, 40);
		confirm.setBounds(frameWidth / 4 - frameWidth / 40, frameHeight / 2
				- frameHeight / 20, frameWidth / 9, frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2 - frameWidth / 30, frameHeight / 2
				- frameHeight / 20, frameWidth / 9, frameHeight / 16);
		cancel.addActionListener(this);
		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		inputOrder.setBounds(frameWidth / 5 + frameWidth / 10, frameHeight / 3
				- frameHeight / 55, frameWidth / 3, frameHeight / 13);
		inputOrder.setFont(new Font("宋体", Font.BOLD, 20));
		inputOrder.setBorder(null);
		inputOrder.setOpaque(false);
		inputOrder.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
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
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {
			if (remindThread != null) {
				remindThread.stop();
				this.remove(jp_wrong);
			}
			jp_wrong = new JPanel();

			OrderBill bill = blServer.inquire(inputOrder.getText());
			System.out.println(inputOrder.getText());
			if (bill == null) {
				input_wrong = "输入的快递单号不存在";
			} else {
				BillNow.setBill(bill);
				this.notifyWatchers(State.COURIERSEARCHAFTER);
			}

			this.add(jp_wrong);
			remindThread = new Remind(jp_wrong, input_wrong);
			remindThread.start();
		}

	}
}
