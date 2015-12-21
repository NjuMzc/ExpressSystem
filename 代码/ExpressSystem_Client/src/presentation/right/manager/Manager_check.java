package presentation.right.manager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_check extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JButton allpass;

	JTable jtable1;
	DefaultTableModel model;
	JScrollPane js;
	DefaultTableCellRenderer dtc;
	CWCheckBoxRenderer cw;
	JPanel billPanel;
	JTextArea billJta;
	JButton pass;
	JButton notpass;
	private List<Watcher> list;
	int currentRow;

	public Manager_check(int frameWidth, int frameHeight) {

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
		model.addColumn("选择");
		model.addColumn("编号");
		model.addColumn("日期");
		model.addColumn("类型");
		model.addColumn("单据号");

		jtable1.getTableHeader().setReorderingAllowed(false);
		jtable1.getTableHeader().setResizingAllowed(false);
		jtable1.getColumnModel().getColumn(0)
				.setCellEditor(new CheckBoxCellEditor());
		cw = new CWCheckBoxRenderer();
		dtc = new ColorRenderer();
		jtable1.getColumnModel().getColumn(0).setCellRenderer(cw);
		jtable1.getColumnModel().getColumn(1).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(2).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(3).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(4).setCellRenderer(dtc);
		jtable1.getColumnModel().getColumn(0)
				.setPreferredWidth(frameWidth / 20);
		jtable1.getColumnModel().getColumn(1)
				.setPreferredWidth(frameWidth / 20);
		jtable1.getColumnModel().getColumn(2)
				.setPreferredWidth(frameWidth / 10);
		jtable1.getColumnModel().getColumn(3)
				.setPreferredWidth(frameWidth / 15);
		jtable1.getColumnModel().getColumn(4)
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
		billPanel = new ChargeBillPanel();
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

		billJta.append("收款单\r\n");
		billJta.append("时间\r\n");
		billJta.append("金额\r\n");
		billJta.append("位置\r\n");
		billJta.append("到达地\r\n");
		billJta.setEditable(false);
	}

	private void initTableModel() {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new Boolean(false));
		vec.add("1");
		vec.add("2015.10.1");
		vec.add("入库单");
		vec.add("123456789");

		for (int i = 0; i < 10; i++) {
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
			pass();
		} else if (e.getSource() == notpass) {
			// 单个审批不通过
		}

		if (e.getSource() == allpass) {
			// 批量审批
			for (int i = 0; i < model.getRowCount(); i++) {
				System.out.println(jtable1.getColumnModel().getColumn(0)
						.getCellEditor().getCellEditorValue());
			}
		}
	}

	private void pass() {
		if (currentRow >= 0) {
			model.removeRow(currentRow);
			currentRow = -1;
		}
	}

	// 内部类：各个单据的panel
	private class ChargeBillPanel extends JPanel {

		public ChargeBillPanel() {

		}
	}

	// ~ Inner Classes:表格的重绘修改
	private class CheckBoxCellEditor extends AbstractCellEditor implements
			TableCellEditor {
		// ~ Static fields/initializers
		// -------------------------------------------------------------------------------------

		private static final long serialVersionUID = 1L;

		// ~ Instance fields
		// ------------------------------------------------------------------------------------------------

		protected JCheckBox checkBox;

		// ~ Constructors
		// ---------------------------------------------------------------------------------------------------

		public CheckBoxCellEditor() {
			checkBox = new JCheckBox();
			checkBox.setHorizontalAlignment(SwingConstants.CENTER);
			// checkBox.setBackground( Color.white);
		}

		// ~ Methods
		// --------------------------------------------------------------------------------------------------------

		@Override
		public Object getCellEditorValue() {
			return Boolean.valueOf(checkBox.isSelected());
		}

		// ~
		// ----------------------------------------------------------------------------------------------------------------

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			checkBox.setSelected(((Boolean) value).booleanValue());

			return checkBox;

		}
	 
	} // end class CheckBoxCellEditor

	private class CWCheckBoxRenderer extends JCheckBox implements
			TableCellRenderer {
		// ~ Static fields/initializers
		// -------------------------------------------------------------------------------------

		private static final long serialVersionUID = 1L;

		// ~ Instance fields
		// ------------------------------------------------------------------------------------------------

		Border border = new EmptyBorder(1, 2, 1, 2);

		// ~ Constructors
		// ---------------------------------------------------------------------------------------------------

		public CWCheckBoxRenderer() {
			super();
			setOpaque(true);
			setHorizontalAlignment(SwingConstants.CENTER);
		}

		// ~ Methods
		// --------------------------------------------------------------------------------------------------------

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (value instanceof Boolean) {
				setSelected(((Boolean) value).booleanValue());

				// setEnabled(table.isCellEditable(row, column));
				setForeground(table.getForeground());
				setBackground(table.getBackground());

			}
			return this;
		}
	}
//
//	private class ColorRenderer extends DefaultTableCellRenderer {
//
//		public Component getTableCellRendererComponent(JTable table,
//				Object value, boolean isSelected, boolean hasFocus, int row,
//				int column) {
//			if (row % 2 == 0)
//				setBackground(new Color(221, 232, 216));
//			else
//				setBackground(new Color(193, 213, 182));
//			return super.getTableCellRendererComponent(table, value,
//					isSelected, hasFocus, row, column);
//		}
//	}
}