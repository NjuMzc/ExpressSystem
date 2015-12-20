package presentation.right.accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

//制作报表
public class AccountantMakeSheet extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JPanel input;
	JLabel start;
	JLabel end;
	JComboBox<String>[] startbox;
	JComboBox<String>[] endbox;
	JLabel inmoney;
	JButton search;

	DefaultTableModel model;
	JTable table;
	JScrollPane js;

	JPanel addPanel;
	JTextArea jta;
	JButton export;

	private List<Watcher> list;

	public AccountantMakeSheet(int frameWidth, int frameheight) {
		this.frameHeight = frameheight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		input = new JPanel();
		start = new JLabel("开始时间");
		start.setFont(new Font("宋体", Font.PLAIN, 15));
		end = new JLabel("结束时间");
		end.setFont(new Font("宋体", Font.PLAIN, 15));
		startbox = new JComboBox[3];
		endbox = new JComboBox[3];

		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		js = new JScrollPane(table);
		search = new JButton("查询");

		init();

		for (int i = 0; i < 3; i++) {
			input.add(startbox[i]);
		}
		for (int i = 0; i < 3; i++) {
			input.add(endbox[i]);
		}
		input.add(search);
		input.add(js);
		input.add(start);
		input.add(end);
		this.add(input);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		YearMonthDay time1 = new YearMonthDay();
		startbox[0] = time1.getCboYear();
		startbox[1] = time1.getCboMonth();
		startbox[2] = time1.getCboDay();
		YearMonthDay time2 = new YearMonthDay();
		endbox[0] = time2.getCboYear();
		endbox[1] = time2.getCboMonth();
		endbox[2] = time2.getCboDay();

		for (int i = 0; i < 3; i++) {
			startbox[i].setBounds(frameWidth / 15 * (i + 2), frameHeight / 20,
					frameWidth / 15, frameHeight / 20);
		}
		for (int i = 0; i < 3; i++) {
			endbox[i].setBounds(frameWidth / 15 * (i + 2), frameHeight / 10,
					frameWidth / 15, frameHeight / 20);
		}

		input.setLayout(null);
		input.setBounds(0, 0, frameWidth / 2, frameHeight);
		start.setBounds(frameWidth / 20, frameHeight / 20, frameWidth / 12,
				frameHeight / 20);
		end.setBounds(frameWidth / 20, frameHeight / 10, frameWidth / 12,
				frameHeight / 20);
		js.setBounds(0, frameHeight / 5, frameWidth / 2, frameHeight);
		search.setBounds(frameWidth / 8 * 3, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		search.addActionListener(this);

		initTable();
	}

	private void initTable() {
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				addAddPanel();
			}
		});

		model.addColumn("编号");
		model.addColumn("日期");
		model.addColumn("类型");
		model.addColumn("单据号");

		initTableModel();
	}

	private void addAddPanel() {
		addPanel = new JPanel();
		jta = new JTextArea();
		export = new JButton("导出报表");
		addPanel.setLayout(null);
		addPanel.setBounds(frameWidth / 2, 0, frameWidth / 4, frameHeight);
		jta.setBounds(0, 0, frameWidth / 2, frameHeight / 4 * 3);
		export.setBounds(frameWidth / 40 * 3, frameHeight / 8 * 7,
				frameWidth / 10, frameHeight / 20);

		jta.append("收款单\r\n");
		jta.append("金額\r\n");
		jta.append("日期 \r\n");

		addPanel.add(jta);
		addPanel.add(export);

		this.add(addPanel);
		this.repaint();

	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();

		vec.add("1");
		vec.add("2015.12.12");
		vec.add("收款单");
		vec.add("123456789");

		model.addRow(vec);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
