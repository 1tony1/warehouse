package table;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sql.sqlmess;

public class liveTable {

	public static DefaultTableModel tablemode;
	public static Vector v;
	static sqlmess sql = new sqlmess();
	public static Vector vtitle = new Vector<String>();
	public static JTable table=null;
	public static JTable lt() {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("��        ��");
		vtitle.add("ֱ �� id");
		vtitle.add("ֱ������");
		vtitle.add("ֱ������");
		vtitle.add("�ϴ��û�");
		vtitle.add("��������");
		
		v = sql.getAllLive();
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	public static JTable lt(String text) {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("��        ��");
		vtitle.add("ֱ �� id");
		vtitle.add("ֱ������");
		vtitle.add("ֱ������");
		vtitle.add("�ϴ��û�");
		vtitle.add("��������");
		
		v = sql.retrievallive(text);
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
}
