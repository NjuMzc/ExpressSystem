package client;

import java.rmi.RemoteException;
import client.blDriver.accountSetblservice_Driver;
import client.blDriver.bankblservice_Driver;
import client.blDriver.billsblservice_Driver;
import client.blDriver.constantblservice_Driver;
import client.blDriver.informationblservice_Driver;
import client.blDriver.paymentblservice_Driver;
import client.blDriver.salaryblservice_Driver;
import client.blDriver.storageblservice_Driver;
import client.blDriver.systemblservice_Driver;
import client.blDriver.transportblservice_Driver;
import client.businesslogic.accountSetbl.accountSetbl_Stub;
import client.businesslogic.bankbl.bankServer_Stub;
import client.businesslogic.billsbl.billApprover_Stub;
import client.businesslogic.billsbl.billFinder_Stub;
import client.businesslogic.billsbl.billMaker_Stub;
import client.businesslogic.constantbl.constantServer_Stub;
import client.businesslogic.informationbl.informationServer_Stub;
import client.businesslogic.paymentbl.paymentServer_Stub;
import client.businesslogic.salarybl.salaryServer_Stub;
import client.businesslogic.storagebl.storageServer_Stub;
import client.businesslogic.systembl.systemServer_Stub;
import client.businesslogic.transportbl.transportBillsMaker_Stub;
import client.businesslogic.transportbl.transportInquiry_Stub;
import client.businesslogicservice.accountSetblservice.accountSetter;
import client.businesslogicservice.bankblservice.bankServer;
import client.businesslogicservice.billsblservice.billApprover;
import client.businesslogicservice.billsblservice.billFinder;
import client.businesslogicservice.billsblservice.billMaker;
import client.businesslogicservice.constantblservice.constantServer;
import client.businesslogicservice.informationblservice.informationServer;
import client.businesslogicservice.paymentblservice.paymentServer;
import client.businesslogicservice.salaryblservice.salaryServer;
import client.businesslogicservice.storageblservice.storageServer;
import client.businesslogicservice.systemblservice.systemServer;
import client.businesslogicservice.transportblservice.transportBillsMaker;
import client.businesslogicservice.transportblservice.transportInquiry;
import client.dataservice.constantdataservice.constantDataServer;
import client.vo.BillVO;
import client.vo.Message;
import client.dataDriver.*;
import client.dataStub.accountSetDataServer_Stub;
import client.dataStub.bankDataServer_Stub;
import client.dataStub.billsDataServer_Stub;
import client.dataStub.constantDataServer_Stub;
import client.dataStub.informationDataServer_Stub;
import client.dataStub.paymentDataServer_Stub;
import client.dataservice.accountSetdataservice.accountSetDataServer;
import client.dataservice.bankdataservice.bankDataServer;
import client.dataservice.billsdataservice.billsDataServer;
import client.dataservice.constantdataservice.constantDataServer;
import client.dataservice.informationdataservice.informationDataServer;
import client.dataservice.paymentdataservice.paymentDataServer;
import client.dataservice.salarydataservice.salaryDataServer;
import client.dataservice.storagedataservice.storageDataServer;
import client.dataservice.systemdataservice.systemDataServer;
import client.dataservice.transportdataservice.transportDataServer;
import client.po.BankPO;
import client.po.ConstantPO;
import client.po.InformationPO;
import client.po.PaymentPO;
import client.vo.GoodVO;
import client.vo.Message;
import client.vo.StorageVO;
import client.blDriver.*;
import client.po.*;


public class Driver {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		Message message=new Message();
	      accountSetblservice_Driver accountsetbldriver=new accountSetblservice_Driver();
	      accountSetter accountsetter =new accountSetbl_Stub();
	      accountsetbldriver.drive(accountsetter, message);
	      System.out.println("--------------------------------------------------------------------------");
	      
	     bankblservice_Driver bankblservicedriver =new bankblservice_Driver();
	     bankServer bankserver =new bankServer_Stub();
	     bankblservicedriver.drive(bankserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     billsblservice_Driver billsblservicedrive =new billsblservice_Driver();
	     billApprover billapprover =new billApprover_Stub();
	     billFinder billfinder =new billFinder_Stub();
	     billMaker billmaker =new billMaker_Stub();
	     billsblservicedrive.drive(billmaker, billapprover, billfinder, message);
	     System.out.println("--------------------------------------------------------------------------");
	    
	     constantblservice_Driver constantblservicedriver =new constantblservice_Driver();
	     constantServer constantserver=new constantServer_Stub();
	     constantblservicedriver.drive(constantserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     informationblservice_Driver informationblservicedrive =new informationblservice_Driver();
	     informationServer informationserver =new informationServer_Stub();
	     informationblservicedrive.drive(informationserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     paymentblservice_Driver paymentblservicedriver =new paymentblservice_Driver();
	     paymentServer paymentserver=new paymentServer_Stub();
	     paymentblservicedriver.driver(paymentserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     
	     salaryblservice_Driver salaryblservicedriver =new salaryblservice_Driver();
	     salaryServer salaryserver =new salaryServer_Stub();
	     salaryblservicedriver.drive(salaryserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     storageblservice_Driver storageblservicedriver =new storageblservice_Driver();
	     storageServer storageserver =new storageServer_Stub();
	     storageblservicedriver.drive(storageserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     systemblservice_Driver systemblservicedriver =new systemblservice_Driver();
	     systemServer systemserver =new systemServer_Stub();
	     systemblservicedriver.drive(systemserver, message);
	     System.out.println("--------------------------------------------------------------------------");
	     
	     transportblservice_Driver transportblservicedrive =new transportblservice_Driver();
	     transportInquiry transportinquiry=new transportInquiry_Stub();
	     transportBillsMaker transportbillsmaker =new transportBillsMaker_Stub();
	     transportblservicedrive.dive(transportbillsmaker, transportinquiry, message);
		
		 System.out.println("--------------------------------------------------------------------------");
		
		
		//This is dirver in data
		accountSetDataServer accountSetdata_Stub=new accountSetDataServer_Stub();
		accountSetdataservice_Driver accountSetdataDriver=new accountSetdataservice_Driver();
		accountSetdataDriver.drive(accountSetdata_Stub, message);
		System.out.println("--------------------------------------------------------------------------");
		
		
		bankDataServer bankDataServer= new bankDataServer_Stub();
		BankPO po =new BankPO();
		bankdataservice_Driver driver =new bankdataservice_Driver();
		driver.drive(bankDataServer, po);
		System.out.println("--------------------------------------------------------------------------");
			
		billsDataServer billsDataServer_Stub = new  billsDataServer_Stub();
		Message msg = new Message();
		billsdataservice_Driver driver1 = new billsdataservice_Driver();
        driver1.drive(billsDataServer_Stub,msg);
        System.out.println("--------------------------------------------------------------------------");
        
		constantDataServer constantDataServer_Stub = new constantDataServer_Stub();
		ConstantPO po1 = new ConstantPO();
		constantdataservice_Driver driver11 =  new constantdataservice_Driver();
		driver11.drive(constantDataServer_Stub, po1);
		System.out.println("--------------------------------------------------------------------------");
			
		informationDataServer informationDataServer_Stub = new informationDataServer_Stub();
		InformationPO po11 = new InformationPO();
		informationdataservice_Driver driver111 = new informationdataservice_Driver();
		driver111.drive(informationDataServer_Stub, po11);
		System.out.println("--------------------------------------------------------------------------");
		
		paymentDataServer paymentDataServer_Stub=new paymentDataServer_Stub();
		paymentdataservice_Driver paymentDataDriver=new paymentdataservice_Driver();
		PaymentPO paymentpo=new PaymentPO();
		paymentDataDriver.drive(paymentDataServer_Stub, paymentpo);
		System.out.println("--------------------------------------------------------------------------");
		
		salaryDataServer salaryDataServer_Stub=new client.dataStub.salaryDataServer_Stub();
		salarydataservice_Driver salaryDataDriver=new salarydataservice_Driver();
		salaryDataDriver.drive(salaryDataServer_Stub, message);
		System.out.println("--------------------------------------------------------------------------");
		
		
		storageDataServer storageDataServer_Stub=new client.dataStub.storageDataServer_Stub();
		storagedataservice_Driver storageDataDriver=new storagedataservice_Driver();
		StoragePO storagepo=new StoragePO(1);
		storageDataDriver.drive(storageDataServer_Stub, storagepo);
		System.out.println("--------------------------------------------------------------------------");
		
		systemDataServer systemDataServer_Stub=new client.dataStub.systemDataServer_Stub();
		systemdataservice_Driver systemDataDriver=new systemdataservice_Driver();
		SystemPO systempo=new SystemPO();
		systemDataDriver.drive(systemDataServer_Stub, systempo);
		System.out.println("--------------------------------------------------------------------------");
		
		transportDataServer transportDataServer_Stub=new client.dataStub.transportDataServer_Stub();
		transportdataservice_Driver transportDataDriver=new transportdataservice_Driver();
		GoodPO goodpo=new GoodPO("1", "2", "3");
		transportDataDriver.drive(transportDataServer_Stub, goodpo);
		System.out.println("--------------------------------------------------------------------------");
		
	}

}
