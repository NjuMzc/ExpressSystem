package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_payment extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	DefaultTableModel tableModel;
	JTable jtable;
	JScrollPane js;
	JButton add;

	private List<Watcher> list;

	public Ying_payment(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
		}
		confirm = new JButton("");
		cancel = new JButton("");
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		String[] year = { "2015", "2016", "2017", "2018", "2019", "2020" };
		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		timeInput[0] = new JComboBox<String>(year);
		timeInput[1] = new JComboBox<String>(month);
		timeInput[2] = new JComboBox<String>(day);
		tableModel = new DefaultTableModel();
		jtable = new JTable(tableModel);
		js = new JScrollPane(jtable);
		add = new JButton("");
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");

		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(js);
		this.add(add);
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\装车单right.png");//共用背景
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}

	private void init() {
		jl[0].setText("收款单");
		jl[3].setText("收款快递员编号");
		jl[4].setText("托运订单条形码号");
		jl[2].setText("收款金额");
		jl[1].setText("收款日期");

		jl[0].setBounds(frameWidth / 3-frameWidth/30, frameHeight/10-frameHeight/30, frameWidth / 10, frameHeight / 18);
		jl[0].setFont(new Font("黑体",Font.BOLD,20));
		for (int i = 1; i < 5; i++) {
			jl[i].setBounds(frameWidth /10-frameWidth/30, frameHeight / 14 + frameHeight
					/ 7 * i+frameHeight/70-frameHeight/12, frameWidth /6, frameHeight / 18);
			jl[i].setFont(new Font("宋体",Font.BOLD,16));
		}
		for (int i = 0; i < 3; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 14 + frameHeight
					/7 * (i + 2)+frameHeight/60-frameHeight/12, frameWidth / 9, frameHeight / 20);
			jtf[i].setFont(new Font("宋体",Font.PLAIN,15));

			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 14 + frameHeight / 10+frameHeight/60-frameHeight/30, frameWidth / 12,
					frameHeight / 20);
			time[i].setBounds(frameWidth /3+ frameWidth / 10 * i, frameHeight
					/ 17 +frameHeight/10, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体",Font.PLAIN,14));
			timeInput[i].setFont(new Font("宋体",Font.PLAIN,14));
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5+frameWidth/15, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
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

		initTable();

		js.setBounds(frameWidth / 12 * 5+frameWidth/30, frameHeight / 14 +frameHeight/25+ frameHeight / 15
				* 2, frameWidth / 5, frameHeight / 2-frameHeight/10);
		jtable.setFont(new Font("宋体",Font.PLAIN,15));
		add.setBounds(frameWidth / 12 * 4+frameWidth/20, frameHeight / 10 +frameHeight/2-frameHeight/47
		         ,frameHeight / 19, frameHeight / 19);
		
		ImageIcon icon3 = new ImageIcon("pictures//添加.png");
		Image temp3 = icon3.getImage().getScaledInstance(add.getWidth(),
				add.getHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3= new ImageIcon(temp3);
		add.setIcon(icon3);
		add.addActionListener(this);
	}

	private void initTable() {
		tableModel.addColumn("已有单号列表");
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.getTableHeader().setResizingAllowed(false);
		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();
		vec.add("12345666");

		// 初始化已有单号列表
		tableModel.addRow(vec);
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
			this.notifyWatchers(State.YING_START);
		} else if (e.getSource() == confirm) {
			this.notifyWatchers(State.YING_PAYMENT);
		}

		if (e.getSource() == add) {
			// 添加单号列表
			String input = jtf[2].getText();
			if (!input.equals("")) {
				Vector<String> vec = new Vector<>();
				vec.add(input);
				tableModel.addRow(vec);
				jtf[2].setText("");
			}
		}
	}
}
