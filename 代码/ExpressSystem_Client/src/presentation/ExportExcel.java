package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExportExcel {

	JTable table;
	FileOutputStream fos;
	String path;

	public ExportExcel(JTable table, String path, String name) {
		this.table = table;
		this.path = path;
		File file = new File(path + "/" + name + ".xls");
		try {
			this.fos = new FileOutputStream(file);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void export() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet hs = wb.createSheet();
		TableModel tm = table.getModel();
		int row = tm.getRowCount();
		int cloumn = tm.getColumnCount();
		HSSFCellStyle style = wb.createCellStyle();
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 20);
		font1.setBoldweight((short) 700);
		style1.setFont(font);

		for (int i = 0; i < row + 1; i++) {
			HSSFRow hr = hs.createRow(i);
			for (int j = 0; j < cloumn; j++) {
				if (i == 0) {
					String value = tm.getColumnName(j);
					int len = value.length();
					hs.setColumnWidth((short) j, (short) (len * 1100));
					HSSFRichTextString srts = new HSSFRichTextString(value);
					HSSFCell hc = hr.createCell((short) j);
					hc.setCellStyle(style1);
					hc.setCellValue(srts);
				} else {
					System.out.println("vlue  " + tm.getValueAt(i - 1, j));
					if (tm.getValueAt(i - 1, j) != null) {
						String value = tm.getValueAt(i - 1, j).toString();
						HSSFRichTextString srts = new HSSFRichTextString(value);
						HSSFCell hc = hr.createCell((short) j);
						hc.setCellStyle(style);

						if (value.equals("") || value == null) {
							hc.setCellValue(new HSSFRichTextString(""));
						} else {
							hc.setCellValue(srts);
						}
					}
				}
			}
		}

		try {
			wb.write(fos);
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}