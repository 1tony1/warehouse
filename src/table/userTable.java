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
		vtitle.add("序        号");
		vtitle.add("用 户 id");
		vtitle.add("用户名称");
		vtitle.add("用户性别");
		vtitle.add("用户年龄");
		vtitle.add("出生日期");
		vtitle.add("用户类型");
		
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
		vtitle.add("序        号");
		vtitle.add("用 户 id");
		vtitle.add("用户名称");
		vtitle.add("用户性别");
		vtitle.add("用户年龄");
		vtitle.add("出生日期");
		vtitle.add("用户类型");
		
		v = sql.retrievalusers(text);
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
}
