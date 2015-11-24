package presentation.right.courier;

import javax.swing.*;

import presentation.Data;
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

public class CourierSearch extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JLabel wrong;
	JButton confirm;
	JButton cancel;
	JFormattedTextField inputOrder;
	boolean isWrongShow = false;
	private List<Watcher> list;

	public CourierSearch(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel("快递物流系统");
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		wrong = new JLabel("输入的快递单号不存在");
		inputOrder = new JFormattedTextField(new DecimalFormat("###,#### "));
		inputOrder.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				if (inputOrder.getText().length() > 10) {
					event.consume();
				}
			}
		});
		inputOrder.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent comp) {
				JTextField field = (JTextField) comp;
				boolean passed = false;
				try {
					String input = field.getText();
					if (input.length() == 10) {
						int index = 0;
						for (int i = 0; i < 10; i++) {
							if (input.charAt(i) >= '0'
									&& input.charAt(i) <= '9') {
								index++;
							}
						}

						if (index == 10) {
							passed = true;
							System.out.println("index="+index);
						}
					}
				} catch (NumberFormatException e) {
				}
				if (!passed) {
					comp.getToolkit().beep();
					field.selectAll();
				}
				return passed;
			}
		});

		init();

		this.add(remind);
		this.add(confirm);
		this.add(cancel);
		this.add(wrong);
		this.add(inputOrder);
	}

	private void init() {
		remind.setForeground(Color.blue);
		remind.setBounds(frameWidth / 4, frameHeight / 3, frameWidth / 4, 40);
		confirm.setBounds(frameWidth / 4, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
		cancel.addActionListener(this);
		wrong.setBounds(frameWidth / 2, frameHeight / 4 * 3, 150, 30);
		wrong.setForeground(new Color(227, 23, 13));
		wrong.setVisible(isWrongShow);
		inputOrder.setBounds(frameWidth / 2, frameHeight / 3, 150, 30);
		inputOrder.setValue(new Integer(1111111111));

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

		}

	}
}
