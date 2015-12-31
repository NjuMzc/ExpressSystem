package presentation.right.stockman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hslf.record.Record;

import businesslogic.storagebl.StorageManagerImpl;
import businesslogic.storagebl.StorageServerImpl;
import businesslogicservice.storageblservice.StorageManager;
import businesslogicservice.storageblservice.StorageServer;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;
import vo.storagebl.ChaKanVO;
import vo.storagebl.RecordVO;

public class StockmanSearch extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton search;
	private List<Watcher> list;

	JLabel time[];
	JComboBox<String>[] timeInput;
	JLabel timeover[];
	JComboBox<String>[] timeInputover;

	JPanel addpanel;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane js;
	JLabel inStock;
	JLabel outStock;
	JTextField jtfIn;
	JTextField jtfOut;
	DefaultTableCellRenderer dtc;

	StorageServer storageServer;
	double chukuMoney;
	double rukuMoney;

	public StockmanSearch(int frameWidth, int frameHeight) {
		storageServer=new StorageServerImpl();
		chukuMoney=0;
		rukuMoney=0;

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			jl[i] = new JLabel();
		}
		search = new JButton("查询");

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		timeover = new JLabel[3];
		timeInputover = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
			timeover[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();
		YearMonthDay time2 = new YearMonthDay();
		timeInputover[0] = time2.getCboYear();
		timeInputover[1] = time2.getCboMonth();
		timeInputover[2] = time2.getCboDay();
		dtc = new ColorRenderer();

		init();

		for (int i = 0; i < 2; i++) {
			this.add(jl[i]);
		}
		this.add(search);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
			this.add(timeover[i]);
			this.add(timeInputover[i]);
		}

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		jl[0].setText("起始时间");
		jl[1].setText("中止时间 ");
		jl[0].setBounds(frameWidth / 6, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		jl[1].setBounds(frameWidth / 2 + frameWidth / 10, frameHeight / 10,
				frameWidth / 10, frameHeight / 20);
		search.setBounds(frameWidth / 4, frameHeight / 4, frameWidth / 10,
				frameHeight / 20);
		search.addActionListener(this);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 12 + frameWidth / 10 * i,
					frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
			time[i].setBounds(frameWidth / 6 + frameWidth / 10 * i, frameHeight
					/ 20 + frameHeight / 10, frameWidth / 12, frameHeight / 20);
		}

		timeover[0].setText("年");
		timeover[1].setText("月");
		timeover[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInputover[i].setBounds(frameWidth / 12 * 5 + frameWidth / 10
					* i, frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
			timeover[i].setBounds(frameWidth / 2 + frameWidth / 10 * i,
					frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
		}
	}

	private void addPanel() {
		if(addpanel!=null){
			this.remove(addpanel);
		}
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		js = new JScrollPane(table);
		inStock = new JLabel("入库合计");
		outStock = new JLabel("出库合计");
		jtfIn = new JTextField();
		jtfIn.setText(""+rukuMoney);
		jtfOut = new JTextField();
		jtfOut.setText(""+chukuMoney);

		js.setBounds(0, 0, frameWidth / 4 * 3, frameHeight / 2);
		inStock.setBounds(0, frameHeight / 2, frameWidth / 10, frameHeight / 20);
		outStock.setBounds(0, frameHeight / 2 + frameHeight / 10,
				frameWidth / 10, frameHeight / 20);
		jtfIn.setBounds(frameWidth / 10, frameHeight / 2, frameWidth / 10,
				frameHeight / 20);
		jtfOut.setBounds(frameWidth / 10, frameHeight / 2 + frameHeight / 10,
				frameWidth / 10, frameHeight / 20);
		jtfIn.setEditable(false);
		jtfOut.setEditable(false);
		
		initTable();

		addpanel.add(jtfIn);
		addpanel.add(jtfOut);
		addpanel.add(js);
		addpanel.add(inStock);
		addpanel.add(outStock);
		this.add(addpanel);
		this.repaint();
	}

	private void initTable() {
		tableModel.addColumn("快递编号");
		tableModel.addColumn("出/入库");
		tableModel.addColumn("金额");
		tableModel.addColumn("库存位置");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setCellRenderer(dtc);
		table.getColumnModel().getColumn(1).setCellRenderer(dtc);
		table.getColumnModel().getColumn(2).setCellRenderer(dtc);
		table.getColumnModel().getColumn(3).setCellRenderer(dtc);

		initTableModel();
	}

	private void initTableModel() {

		String year = timeInput[0].getSelectedItem().toString();
		String month = timeInput[1].getSelectedItem().toString();
		String day = timeInput[2].getSelectedItem().toString();
		String date = year + "-" + month + "-" + day;

		String year1 = timeInputover[0].getSelectedItem().toString();
		String month1 = timeInputover[1].getSelectedItem().toString();
		String day1 = timeInputover[2].getSelectedItem().toString();
		String date1 = year1 + "-" + month1 + "-" + day1;

		ChaKanVO vo=storageServer.chaKan(date, date1);

		if(vo.isWrong()){
			//错误信息处理
			System.out.println(vo.getWrongMessage());
		}else{
			Iterator<RecordVO> records=vo.getList();

			while (records.hasNext()) {
				System.out.println("assss");
				Vector<String> vec2 = new Vector<>();
				RecordVO a= records.next();
				vec2.add(a.getGood().getID());
				
				if(a.getType().equals("IMPORT")){
					vec2.add("入库");
					rukuMoney+=Double.valueOf(a.getMoney());
				}else {
					vec2.add("出库");
					chukuMoney+=Double.valueOf(a.getMoney());
					System.out.println("出库总金额："+chukuMoney);
				}
				vec2.add(a.getMoney());
				String location =a.getLocation();
				location=location.substring(0,2)+"区"+location.substring(2, 4)+"排"+location.substring(4, 6)+"架"+location.substring(6,8)+"位";
				vec2.add(location);
				tableModel.addRow(vec2);
				
			}
			jtfIn.setText(""+rukuMoney);
			jtfOut.setText(""+chukuMoney);
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
		if (e.getSource() == search) {
			addPanel();
		}
	}
}
