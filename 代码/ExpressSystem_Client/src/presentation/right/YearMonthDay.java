package presentation.right;

import javax.swing.JComboBox;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class YearMonthDay {

	private final int STARTYEAR = 2016;// 年份的开始值
	private final int ENDYEAR = 2021;// 年份的结束值

	JComboBox cboYear = new JComboBox();
	public JComboBox getCboYear() {
		return cboYear;
	}
 

	public JComboBox getCboMonth() {
		return cboMonth;
	}
 

	public JComboBox getCboDay() {
		return cboDay;
	}
 

	JComboBox cboMonth = new JComboBox();
	JComboBox cboDay = new JComboBox();

	public YearMonthDay() {
		jbInit();
	}

	private void jbInit() {

		// 年的下拉选择框
		cboYear.setFont(new java.awt.Font("Dialog", Font.BOLD, 10));
		cboYear.setBounds(new Rectangle(0, 0, 55, 18));
		// 月的下拉选择框
		cboMonth.setFont(new java.awt.Font("Dialog", Font.BOLD, 10));
		cboMonth.setBounds(new Rectangle(80, 0, 45, 18));
		cboMonth.addItemListener(new DateItemAdapter(this));
		// 日的下拉选择框
		cboDay.setFont(new java.awt.Font("Dialog", Font.BOLD, 10));
		cboDay.setBounds(new Rectangle(150, 0, 45, 18));

		// 添加初始值
		AddInfo();
	}

	private void AddInfo() {
		// 年下拉选择框
		for (int i = STARTYEAR; i < ENDYEAR; i++) {
			cboYear.addItem("" + i);
		}

		// 月下拉选择框
		for (int i = 0; i < 12; i++) {
			cboMonth.addItem("" + (i + 1));
		}

		// 日下拉选择框
		for (int j = 0; j < 31; j++) {
			cboDay.addItem("" + (j + 1));
		}
	}

	public void cboMonth_itemStateChanged(ItemEvent e) {

		Object obj = cboMonth.getSelectedItem();// 取得选中月份

		if (obj != null) {
			cboDay.removeAllItems();// 清空日的下拉列表框

			int month = Integer.valueOf(obj.toString());
			int days = 31;
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				days = 30;
			} else if (month == 2) {
				// 取得选中年份
				int year = Integer.parseInt(cboYear.getSelectedItem()
						.toString());
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
					// 是闰年
					days = 29;
				} else {
					// 不是闰年
					days = 28;
				}
			}// if

			for (int j = 0; j < days; j++) {
				cboDay.addItem("" + (j + 1));
			}// for
		}// if
	}// if
}// end class
// 事件监听器

class DateItemAdapter implements ItemListener {

	private YearMonthDay adaptee;

	DateItemAdapter(YearMonthDay adaptee) {
		this.adaptee = adaptee;
	}

	public void itemStateChanged(ItemEvent e) {
		adaptee.cboMonth_itemStateChanged(e);
	}
}
