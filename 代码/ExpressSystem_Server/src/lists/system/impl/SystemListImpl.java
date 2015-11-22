package lists.system.impl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import lists.system.SystemList;
import po.SystemUserPO;

public class SystemListImpl implements SystemList {
	final String path="src/server/dataList/userList.dat";
	private ArrayList<SystemUserPO> users; 
	public SystemListImpl() {
		load();
	}
	public boolean addUser(SystemUserPO po) {
		users.add(po);
		save();
		return true;
	}
	public SystemUserPO find(String id) {
		for (SystemUserPO po : users) {
			if(po.getID().equals(id))
				return po;
		}
		return null;
	}
	public boolean delUser(SystemUserPO po) {
		String id=po.getID();
		SystemUserPO poInArray=find(id);
		if(poInArray!=null){
			int index = users.indexOf(poInArray);
			users.remove(index);
			System.out.println("成功删除");
			save();
			return true;
		}else{
			System.out.println("找不到该用户");
			return false;
		}

	}
	public boolean update(SystemUserPO po) {
		String id = po.getID();
		SystemUserPO poInArray=find(id);
		if(poInArray!=null){
			int index = users.indexOf(poInArray);
			users.remove(index);
			users.add(index, po);
			System.out.println("成功更改");
			save();
			return true;
		}else{
			System.out.println("找不到该用户");
			return false;
		}
	}
	
	private void save(){
		File list = new File(path);
		if(!list.exists())
			try {
				list.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(list));
			oos.writeObject(users);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load(){
		File list = new File(path);
		if(!list.exists())
			try {
				list.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			users=(ArrayList<SystemUserPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			users= new ArrayList<SystemUserPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int size() {
		// TODO Auto-generated method stub
		return users.size();
	}
	/*
	 * 测试用后期删除
	 */
	public void print(){
		for(int i=0;i<users.size();i++){
			System.out.println(users.get(i).getID()+" "+users.get(i).getKey()+" "+users.get(i).getIdentity());
		}
	}
	
	public static void main(String[] args) {
		SystemListImpl a = new SystemListImpl();
		a.print();
	}
	
}
