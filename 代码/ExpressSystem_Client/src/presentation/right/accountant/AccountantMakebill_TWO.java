package presentation.right.accountant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.watcher.*;

public class AccountantMakebill_TWO extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	private List<Watcher> list;

	JButton jb[];
	JButton allover;

	DefaultTableModel model;
	JTable table;
	JScrollPane js;

	JPanel addpanel;
	JTextField addjtf[];
	JLabel addlable[];
	JButton addover;

	JPanel changepanel;
	JTextField changejtf[];
	JLabel changelable[];
	JButton changeover;

	public AccountantMakebill_TWO(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		list = new ArrayList<Watcher>();
		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		model = new DefaultTableModel();
		table = new JTable(model);
		js = new JScrollPane(table);

		jb = new JButton[3];
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
		}
		allover = new JButton("建账完成");

		init();

		this.add(js);
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}
		this.add(allover);
	}

	private void init() {
		js.setBounds(0, frameHeight / 10, frameWidth / 4 * 3,
				frameHeight / 5 * 3);
		initTable();
		jb[0].setText("增加");
		jb[1].setText("删除");
		jb[2].setText("修改");
		for (int i = 0; i < 3; i++) {
			jb[i].setBounds(frameWidth / 8 + frameWidth / 5 * i,
					frameHeight / 40, frameWidth / 10, frameHeight / 20);
			jb[i].addActionListener(this);
		}
		allover.setBounds(frameWidth / 40 * 13, frameHeight / 10 * 9,
				frameWidth / 10, frameHeight / 20);
	}

	private void initTable() {
		model.addColumn("名称");
		model.addColumn("金额");

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

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

	private void addChangePanel(Vector<String> vec) {
		changepanel = new JPanel();
		changepanel.setLayout(null);
		changepanel.setBounds(0, frameHeight / 10 * 7, frameWidth / 4 * 3,
				frameHeight / 10);
		changelable = new JLabel[2];
		changejtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			changelable[i] = new JLabel();
			changejtf[i] = new JTextField();
		}
		changeover = new JButton("√");
		changelable[0].setText("名称");
		changelable[1].setText("金额 ");

		for (int i = 0; i < 2; i++) {
			changelable[i].setBounds(frameWidth / 10 * i, 0,
					frameWidth / 28 * 3, frameHeight / 20);
			changejtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 28 * 3, frameHeight / 20);

			changejtf[i].setText(vec.get(i));

			changepanel.add(changelable[i]);
			changepanel.add(changejtf[i]);
		}
		changeover.setBounds(frameWidth / 10 * 7, frameHeight / 20,
				frameWidth / 20, frameHeight / 20);
		changeover.addActionListener(this);

		changepanel.add(changeover);
		this.add(changepanel);
		this.repaint();
	}

	private void addAddPanel() {
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, frameHeight / 10 * 7, frameWidth / 4 * 3,
				frameHeight / 10);
		addlable = new JLabel[2];
		addjtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			addlable[i] = new JLabel();
			addjtf[i] = new JTextField();
		}
		addover = new JButton("√");
		addlable[0].setText("名称");
		addlable[1].setText("金额");

		for (int i = 0; i < 2; i++) {
			addlable[i].setBounds(frameWidth / 10 * i, 0, frameWidth / 28 * 3,
					frameHeight / 20);
			addjtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 28 * 3, frameHeight / 20);

			addpanel.add(addlable[i]);
			addpanel.add(addjtf[i]);
		}
		addover.setBounds(frameWidth / 10 * 7, frameHeight / 20,
				frameWidth / 20, frameHeight / 20);
		addover.addActionListener(this);

		addpanel.add(addover);
		this.add(addpanel);
		this.repaint();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			if (changepanel != null) {
				this.remove(changepanel);
				this.repaint();
			}
			addAddPanel();
		} else if (e.getSource() == jb[1]) {
			if (addpanel != null) {
				this.remove(addpanel);
				this.repaint();
			}

			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0) {
				model.removeRow(selectedRow);
			}

		} else if (e.getSource() == jb[2]) {
			if (addpanel != null) {
				this.remove(addpanel);
				this.repaint();
			}
			if (changepanel != null) {
				this.remove(changepanel);
				this.repaint();
			}

			// 改
			int row = table.getSelectedRow();
			if (row >= 0) {
				Vector<String> vec = new Vector<String>();

				vec.add((String) (table.getValueAt(row, 0)));
				vec.add((String) (table.getValueAt(row, 1)));

				addChangePanel(vec);
				model.removeRow(row);
			}

		}

		if (e.getSource() == addover) {
			this.remove(addpanel);
			this.repaint();

			Vector<String> vec = new Vector<>();
			for (int i = 0; i < 2; i++) {
				vec.add(addjtf[i].getText());
			}

			model.addRow(vec);
		}

		if (e.getSource() == changeover) {
			this.remove(changepanel);
			this.repaint();

			Vector<String> vec = new Vector<>();
			for (int i = 0; i < 2; i++) {
				vec.add(changejtf[i].getText());
			}
			model.addRow(vec);
		}

	}

}
