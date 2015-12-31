package businesslogicservice.storageblservice;

import java.util.Iterator;

import vo.storagebl.ChaKanVO;
import vo.storagebl.ExportVO;
import vo.storagebl.ImportVO;
import vo.storagebl.PanDianVO;

public interface StorageServer {

	public ImportVO Import(ImportVO importMessage);

	public ExportVO Export(ExportVO exportMessage);
	
	public ChaKanVO chaKan(String date1,String date2);
	
	public Iterator<PanDianVO> panDian();
	
	public void exportTable();
	
	public boolean changeStorage(String oldLocation,String newLocation);
}
