package table;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sql.sqlmess;

public class musicTable {

	public static DefaultTableModel tablemode;
	public static Vector v;
	static sqlmess sql = new sqlmess();
	public static Vector vtitle = new Vector<String>();
	public static JTable table=null;
	public static JTable mt() {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("序        号");
		vtitle.add("音 乐 id");
		vtitle.add("音乐名称");
		vtitle.add("音乐类型");
		vtitle.add("上传用户");
		vtitle.add("播放次数");
		vtitle.add("文件大小");
		
		v = sql.getAllMusic();
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	public static JTable mt(String text) {
		if(table==null){
		JTable table = new JTable();
		}
		vtitle = new Vector<String>();
		vtitle.add("序        号");
		vtitle.add("音 乐 id");
		vtitle.add("音乐名称");
		vtitle.add("音乐类型");
		vtitle.add("上传用户");
		vtitle.add("播放次数");
		vtitle.add("文件大小");
		
		v = sql.retrievalmusic(text);
		
		tablemode = new DefaultTableModel(v,vtitle);
		table = new JTable(tablemode);
		
		return table;
		
	}
	
}
