package businesslogic.storagebl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import po.GoodPO;

/**
 * 记录进出库情况的辅助类
 * 
 * @author rabook
 *
 */
public class IORecorder implements Serializable {
	ArrayList<Record> records;

	public IORecorder() {
		records = new ArrayList<>();
	}

	public void addRecord(GoodPO po, IO_Type type, String date, String location) {
		Record record = new Record(po, type, date, location);
		int index = 0;
		for (Record recorder : records) {
			if (date.compareTo(recorder.getDate()) < 0) {
				index = records.indexOf(recorder);
				break;
			}
		}
		records.add(index, record);
	}

	public ArrayList<Record> getRecords(String startTime, String endTime) {
		ArrayList<Record> re = new ArrayList<>();
		for (Record recorder : records) {
			if (recorder.getDate().compareTo(startTime) >= 0 && recorder.getDate().compareTo(endTime) <= 0)
				re.add(recorder);
			else if (recorder.getDate().compareTo(endTime) > 0)
				break;
		}
		return re;
	}

}