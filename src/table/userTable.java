package table;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import frame.mainframe;
import sql.sqlmess;

public class userTable {
	
	public static DefaultTableModel tablemode;
	private static Vector v;
	static sqlmess sql = new sqlmess();
	public  static Vector vtitle = new Vector<String>();
	public static JTable table=null;
	public static JTable ut() {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("��        ��");
		vtitle.add("�� �� id");
		vtitle.add("�û�����");
		vtitle.add("�û��Ա�");
		vtitle.add("�û�����");
		vtitle.add("��������");
		vtitle.add("�û�����");
		
		v = sql.getAllUser();
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
	public static JTable ut(String text) {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("��        ��");
		vtitle.add("�� �� id");
		vtitle.add("�û�����");
		vtitle.add("�û��Ա�");
		vtitle.add("�û�����");
		vtitle.add("��������");
		vtitle.add("�û�����");
		
		v = sql.retrievalusers(text);
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
}
