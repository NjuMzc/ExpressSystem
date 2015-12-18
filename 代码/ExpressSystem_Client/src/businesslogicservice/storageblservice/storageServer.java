package businesslogicservice.storageblservice;

import vo.storagebl.ChaKanVO;
import vo.storagebl.ExportVO;
import vo.storagebl.ImportVO;
import vo.storagebl.PanDianVO;

public interface StorageServer {

	public ImportVO Import(String goodID,String date,String destination,String[] locatino);

	public ExportVO Export(String goodID,String date,String destination,String loader,String transNum);
	
	public ChaKanVO chaKan(String date1,String date2);
	
	public PanDianVO panDian(String date);
	
	public void exportTable();
}
