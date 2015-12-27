package presentation.right.manager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import po.bills.BillApproverPO;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_check extends RightAll implements ActionListener {
	BillApproveServer approver;

	int frameWidth;
	int frameHeight;
	JButton allpass;

	JTable jtable1;
	DefaultTableModel model;
	JScrollPane js;
	DefaultTableCellRenderer dtc;
	JPanel billPanel;
	JTextArea billJta;
	JButton pass;
	JButton notpass;
	private List<Watcher> list;
	int currentRow;

	public Manager_check(int frameWidth, int frameHeight) {
		approver = new BillApproverServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		allpass = new JButton("批量审批");
		model = new DefaultTableModel();
		jtable1 = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				if (column != 0)
					return false;
				else
					return true;
			}
		};
		js = new JScrollPane(jtable1);

		init();

		this.add(js);
		this.add(allpass);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		allpass.setBounds(frameWidth / 3, frameHeight / 10 * 9,
				frameWidth / 10, frameHeight / 20);
		allpass.addActionListener(this);
		initTable();
		js.setBounds(frameWidth / 20, frameHeight / 10, frameWidth / 3,
				frameHeight / 4 * 3);

	}

	private void initTable() {
		model.addColumn("编号");
		model.addColumn("日期");
		model.addColumn("类型");
		model.addColumn("单据号");

		jtable1.getTableHeader().setReorderingAllowed(false);
		jtable1.getTableHeader().setResizingAllowed(false);

		dtc = new ColorRenderer();
		jtable1.getColumnModel().getColumn(0).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(1).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(2).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(3).setCellRenderer(dtc);

		jtable1.getColumnModel().getColumn(0)
				.setPreferredWidth(frameWidth / 25);
		jtable1.getColumnModel().getColumn(1)
				.setPreferredWidth(frameWidth / 15);
		jtable1.getColumnModel().getColumn(2)
				.setPreferredWidth(frameWidth / 10);
		jtable1.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e) {
				currentRow = jtable1.getSelectedRow();
				addPanel();
			}
		});

		initTableModel();
	}

	private void addPanel() {
		if (billPanel != null) {
			this.remove(billPanel);
		}
		// 根据单据号,单据类型判断单据
		billPanel = new JPanel();
		billPanel.setBounds(frameWidth / 5 * 2, frameHeight / 10,
				frameWidth / 3, frameHeight / 4 * 3);
		billPanel.setLayout(null);
		billJta = new JTextArea();
		pass = new JButton("通过");
		notpass = new JButton("不通过");
		billJta.setBounds(0, 0, frameWidth / 3, frameHeight / 2);
		initJta();
		pass.setBounds(frameWidth / 20, frameHeight / 8 * 5, frameWidth / 10,
				frameHeight / 20);
		pass.addActionListener(this);
		notpass.setBounds(frameWidth / 5, frameHeight / 8 * 5, frameWidth / 10,
				frameHeight / 20);
		notpass.addActionListener(this);
		billPanel.add(billJta);
		billPanel.add(pass);
		billPanel.add(notpass);
		this.add(billPanel);
		this.repaint();
	}

	private void initJta() {
		// 单据显示

		BillApproverPO bill = approver.getByNum(currentRow);
		Iterator<String> things = bill.getInform();

		while (things.hasNext()) {
			billJta.append(things.next() + "\r\n");
		}
		billJta.setEditable(false);
	}

	private void initTableModel() {
		Iterator<BillApproverPO> list = approver.getList();
		int counter = 1;

		int row = jtable1.getRowCount();
		for (int i = row - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		while (list.hasNext()) {
			BillApproverPO bill = list.next();
			Iterator<String> easeInform = bill.getEaseInform();

			Vector<Object> vec = new Vector<Object>();
			// vec.add(new Boolean(false));
			vec.add(String.valueOf(counter));
			vec.add(easeInform.next());
			vec.add(easeInform.next());
			vec.add(easeInform.next());

			counter++;

			model.addRow(vec);
		}

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
		if (e.getSource() == pass) {
			// 单个审批通过
			approver.accept(currentRow);
			pass();
		} else if (e.getSource() == notpass) {
			// 单个审批不通过
			approver.refuse(currentRow);
		}

		if (e.getSource() == allpass) {
			// 批量审批
			this.remove(billPanel);
			this.repaint();
			approver.approveAll(); 
		}

		initTableModel();
	}

	private void pass() {
		if (currentRow >= 0) {
			model.removeRow(currentRow);
			currentRow = -1;
		}
	}

}