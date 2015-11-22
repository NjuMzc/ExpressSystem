 
package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_loading extends JPanel implements Watched,ActionListener{

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;
	
	private List<Watcher> list;

	public Ying_loading(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		
		list=new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[9];
		for (int i = 0; i < 9; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 9; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
	}

	private void init() {
		jl[0].setText("装车单");
		jl[1].setText("装车日期");
		jl[2].setText("车辆编号");
		jl[3].setText("达到地");
		jl[4].setText("监运员");
		jl[5].setText("押运员");
		jl[6].setText("订单条形码号");
		jl[7].setText("汽运编号");
		jl[8].setText("合计");

		jl[0].setBounds(frameWidth / 2, frameHeight / 20, 100, 65);
		for (int i = 1; i < 9; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 20 + frameHeight / 15
					* i, 100, 65);
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
		cancel.addActionListener(this);
	}

	public void addWatcher(Watcher watcher) {
		 list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
	 list.remove(watcher);
	}

	public void notifyWatchers(State state) {
	 for(Watcher watcher:list){
		 watcher.update(state);
	 }
	}

	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==cancel){
			 this.notifyWatchers(State.YING_START);
		 }
	}
}
