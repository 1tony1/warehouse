package table;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sql.sqlmess;

public class gameTable {

	public static DefaultTableModel tablemode;
	public static Vector v;
	static sqlmess sql = new sqlmess();
	public static Vector vtitle = new Vector<String>();
	public static JTable table=null;
	public static JTable gt() {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("序        号");
		vtitle.add("游 戏 id");
		vtitle.add("游戏名称");
		vtitle.add("游戏类型");
		vtitle.add("上传用户");
		vtitle.add("浏览次数");
		vtitle.add("文件大小");
		
		v = sql.getAllGame();
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
	public static JTable gt(String text) {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("序        号");
		vtitle.add("游 戏 id");
		vtitle.add("游戏名称");
		vtitle.add("游戏类型");
		vtitle.add("上传用户");
		vtitle.add("浏览次数");
		vtitle.add("文件大小");
		
		v = sql.retrievalgame(text);
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
}
