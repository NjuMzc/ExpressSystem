package po.Institution.storageAssist;

import java.io.Serializable;
import java.util.ArrayList;

import po.GoodPO;
import vo.storagebl.PanDianVO;

/**
 * 仓库位置信息的辅助类,用于存储仓库各位置的货物信息、入库时间(用于库存盘点）
 * 
 * @author rabook
 *
 */
public class CapacityReocrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1738284309651167038L;
	private final int area = 4;
	private final int row = 8;
	private final int shelf = 10;
	private final int position = 30;
	private StorageInfo[][][][] info;
	private int num[];

	public CapacityReocrder() {
		info = new StorageInfo[area][row][shelf][position];
		num = new int[4];
	}

	public Double getRate(int i) {
		int allNum = row * shelf * position;
		double rate = 1.0 * num[i] / allNum;
		return rate;
	}

	public boolean importGood(GoodPO good, String time, String location) {
		// location的格式应为“X-XX-XX-XXX”分别为区排架位号，位数不够左边补0
		int a = Integer.valueOf(location.substring(0, 2)) - 1;
		int b = Integer.valueOf(location.substring(2, 4)) - 1;
		int c = Integer.valueOf(location.substring(4, 6)) - 1;
		int d = Integer.valueOf(location.substring(6, 8)) - 1;
		StorageInfo storage = new StorageInfo(good, time);
		try {
			if (info[a][b][c][d] != null) {
				System.out.println("该位置已存储货物，请选择其他位置");
				return false;
			}
			info[a][b][c][d] = storage;
			num[a] += 1;
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("位置超限，请重新设置");
			return false;
		}
	}

	public boolean exportGood(String location) {
		// location的格式应为“X-XX-XX-XXX”分别为区排架位号，位数不够左边补0
		int a = Integer.valueOf(location.substring(0, 2)) - 1;
		int b = Integer.valueOf(location.substring(2, 4)) - 1;
		int c = Integer.valueOf(location.substring(4, 6)) - 1;
		int d = Integer.valueOf(location.substring(6, 8)) - 1;
		try {
			if (info[a][b][c][d] == null) {
				System.out.println("该位置无货物，请选择其他位置");
				return false;
			}
			info[a][b][c][d] = null;
			num[a] -= 1;
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("位置超限，请重新设置");
			return false;
		}
	}

	public boolean isEmpty(String location) {
		int a = Integer.valueOf(location.substring(0, 2)) - 1;
		int b = Integer.valueOf(location.substring(2, 4)) - 1;
		int c = Integer.valueOf(location.substring(4, 6)) - 1;
		int d = Integer.valueOf(location.substring(6, 8)) - 1;
		return info[a][b][c][d] == null;
	}

	public StorageInfo getInfo(String location) {
		int a = Integer.valueOf(location.substring(0, 2)) - 1;
		int b = Integer.valueOf(location.substring(2, 4)) - 1;
		int c = Integer.valueOf(location.substring(4, 6)) - 1;
		int d = Integer.valueOf(location.substring(6, 8)) - 1;
		return info[a][b][c][d];
	}

	public StorageInfo[] getAllInfor(int area, int row, int shelf) {
		return info[area][row][shelf];
	}
	
	public ArrayList<PanDianVO> getAllList(){
		ArrayList<PanDianVO> pandian = new ArrayList<>();
		for (int i = 0; i < area; i++) {
			for(int j=0;j<row;j++){
				for(int k=0;k<shelf;k++){
					for(int m=0;m<position;m++){
						StorageInfo temp=info[i][j][k][m];
						if(temp!=null){
							String num=temp.getGood().getID();
							String date=temp.getTime();
							String destination= temp.getGood().getDestination();
							String[] location={""+(i+1),""+(j+1),""+(1+k),""+(m+1)};
							PanDianVO pan = new PanDianVO(num,date,destination,location);
							pandian.add(pan);
						}
					}
				}
			}
		}
		
		return pandian;
	}
}
