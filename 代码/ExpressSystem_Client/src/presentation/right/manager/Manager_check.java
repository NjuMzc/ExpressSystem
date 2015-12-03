package presentation.right.manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_check extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JButton allpass;

	JPanel tobeChecked;
	JTable jtable1;
	DefaultTableModel model;
	JScrollPane js;
	DefaultTableCellRenderer dtc;
	CWCheckBoxRenderer cw;
	private List<Watcher> list;

	public Manager_check(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		allpass = new JButton("批量审批");
		tobeChecked = new JPanel();
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

		tobeChecked.add(js);
		this.add(tobeChecked);
		this.add(allpass);
	}

	private void init() {
		allpass.setBounds(frameWidth / 3, frameHeight / 10 * 9, 100, 30);
		initTable();
		js.setBounds(0, 0, frameWidth / 8 * 3, frameHeight / 4 * 3);
		tobeChecked.setBounds(frameWidth / 20, frameHeight / 10,
				frameWidth / 8 * 3, frameHeight / 4 * 3);
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

		Vector<Object> vec = new Vector<Object>();
		vec.add(new Boolean(false));
		vec.add("1");
		vec.add("2015.10.1");
		vec.add("入库单");
		vec.add("110");

		for (int i = 0; i < 40; i++) {
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

	}

	// ~ Inner Classes
	// ----------------------------------------------------------------------------------------------------

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

	private class ColorRenderer extends DefaultTableCellRenderer {

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (row % 2 == 0)
				setBackground(new Color(64, 224, 208));
			else
				setBackground(new Color(0, 191, 255));
			return super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
		}
	}
}