package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import sql.GetCon;

public class sqlmess {

public boolean login(String username,String password){
		
		boolean tt = false;
		
		Connection con = GetCon.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		String sql = "select * from syss where name = ? and password = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			rs = pre.executeQuery();
			if (rs.next()) {
				tt = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			
			GetCon.colse(rs, pre, con);
			
		}
		
		return tt;
	}

	public static Vector getAllUser(){
		
		Vector vv = new Vector();
		Connection con = GetCon.getConnection();
		String sql = "select id,username,sex,age,hiredate,typrs from users";
		PreparedStatement pre =null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			int i = 1;
			while (rs.next()) {
				
				Vector v = new Vector();
				v.add(i++);
				v.add(rs.getString("id"));
				v.add(rs.getString("username"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("age"));
				v.add(rs.getString("hiredate"));
				v.add(rs.getString("typrs"));
				vv.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			GetCon.colse(rs, pre, con);
		}
		
		return vv;
		
	}
	
	public static Vector getAllMusic(){
		
		Vector vv = new Vector();
		Connection con = GetCon.getConnection();
		String sql = "select id,name,type,uploader,amount,sizes from music";
		PreparedStatement pre =null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			int i = 1;
			while (rs.next()) {
				
				Vector v = new Vector();
				v.add(i++);
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("type"));
				v.add(rs.getString("uploader"));
				v.add(rs.getString("amount"));
				v.add(rs.getString("sizes"));
				vv.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			GetCon.colse(rs, pre, con);
		}
		
		return vv;
		
	}
	
	public static Vector getAllGame(){
		
		Vector vv = new Vector();
		Connection con = GetCon.getConnection();
		String sql = "select id,name,type,uploader,amount,sizes from game";
		PreparedStatement pre =null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			int i = 1;
			while (rs.next()) {
				
				Vector v = new Vector();
				v.add(i++);
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("type"));
				v.add(rs.getString("uploader"));
				v.add(rs.getString("amount"));
				v.add(rs.getString("sizes"));
				vv.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			GetCon.colse(rs, pre, con);
		}
		
		return vv;
		
	}
	
public static Vector getAllLive(){
		
		Vector vv = new Vector();
		Connection con = GetCon.getConnection();
		String sql = "select id,name,type,uploader,spectators from live";
		PreparedStatement pre =null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			int i = 1;
			while (rs.next()) {
				
				Vector v = new Vector();
				v.add(i++);
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("type"));
				v.add(rs.getString("uploader"));
				v.add(rs.getString("spectators"));
				vv.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			GetCon.colse(rs, pre, con);
		}
		
		return vv;
		
	}

public boolean addUser(Map map) {
	boolean tt = false;
	
	String sql = "insert into users (id,username,sex,age,hiredate,typrs) values (?,?,?,?,?,?)";
	Connection con = GetCon.getConnection();
	PreparedStatement pre =null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("id"));
		pre.setObject(2, map.get("username"));
		pre.setObject(3, map.get("sex"));
		pre.setObject(4, map.get("age"));
		pre.setObject(5, map.get("hiredate"));
		pre.setObject(6, map.get("typrs"));
		int i = pre.executeUpdate();
		if (i>0) {
			tt = true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
}

public boolean addMusic(Map map) {
	boolean tt = false;
	
	String sql = "insert into music (id,name,type,uploader,amount,sizes) values (?,?,?,?,?,?)";
	Connection con = GetCon.getConnection();
	PreparedStatement pre =null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("id"));
		pre.setObject(2, map.get("name"));
		pre.setObject(3, map.get("type"));
		pre.setObject(4, map.get("uploader"));
		pre.setObject(5, map.get("amount"));
		pre.setObject(6, map.get("sizes"));
		int i = pre.executeUpdate();
		if (i>0) {
			tt = true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
}
public boolean addGame(Map map) {
	boolean tt = false;
	
	String sql = "insert into game (id,name,type,uploader,amount,sizes) values (?,?,?,?,?,?)";
	Connection con = GetCon.getConnection();
	PreparedStatement pre =null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("id"));
		pre.setObject(2, map.get("name"));
		pre.setObject(3, map.get("type"));
		pre.setObject(4, map.get("uploader"));
		pre.setObject(5, map.get("amount"));
		pre.setObject(6, map.get("sizes"));
		int i = pre.executeUpdate();
		if (i>0) {
			tt = true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
}
public boolean addLive(Map map) {
	boolean tt = false;
	
	String sql = "insert into live (id,name,type,uploader,spectators) values (?,?,?,?,?)";
	Connection con = GetCon.getConnection();
	PreparedStatement pre =null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("id"));
		pre.setObject(2, map.get("name"));
		pre.setObject(3, map.get("type"));
		pre.setObject(4, map.get("uploader"));
		pre.setObject(5, map.get("spectators"));
		int i = pre.executeUpdate();
		if (i>0) {
			tt = true;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
}
public Map getOneUserById(String id){
	
	Map map = new HashMap();
	Connection con = GetCon.getConnection();
	String sql = "select id,username,sex,age,hiredate,nvl(typrs,' ') typrs from users where id = ?";
	PreparedStatement pre = null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		rs = pre.executeQuery();
		if (rs.next()) {
			map.put("id", rs.getString("id"));
			map.put("username", rs.getString("username"));
			map.put("sex", rs.getString("sex"));
			map.put("age", rs.getString("age"));
			map.put("hiredate", rs.getString("hiredate"));
			map.put("typrs", rs.getString("typrs"));
		}
		System.out.println(map);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		
		GetCon.colse(rs, pre, con);
		
	}
	
	return map;
	
}

public Map getOneMusicById(String id){
	
	Map map = new HashMap();
	Connection con = GetCon.getConnection();
	String sql = "select id,name,type,uploader,amount,sizes from music where id = ?";
	PreparedStatement pre = null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		rs = pre.executeQuery();
		if (rs.next()) {
			map.put("id", rs.getString("id"));
			map.put("name", rs.getString("name"));
			map.put("type", rs.getString("type"));
			map.put("uploader", rs.getString("uploader"));
			map.put("amount", rs.getString("amount"));
			map.put("sizes", rs.getString("sizes"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		
		GetCon.colse(rs, pre, con);
		
	}
	
	return map;
	
}

public Map getOneGameById(String id){
	
	Map map = new HashMap();
	Connection con = GetCon.getConnection();
	String sql = "select id,name,type,uploader,amount,sizes from game where id = ?";
	PreparedStatement pre = null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		rs = pre.executeQuery();
		if (rs.next()) {
			map.put("id", rs.getString("id"));
			map.put("name", rs.getString("name"));
			map.put("type", rs.getString("type"));
			map.put("uploader", rs.getString("uploader"));
			map.put("amount", rs.getString("amount"));
			map.put("sizes", rs.getString("sizes"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		
		GetCon.colse(rs, pre, con);
		
	}
	
	return map;
	
}

public Map getOneLiveById(String id){
	
	Map map = new HashMap();
	Connection con = GetCon.getConnection();
	String sql = "select id,name,type,uploader,spectators from live where id = ?";
	PreparedStatement pre = null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		rs = pre.executeQuery();
		if (rs.next()) {
			map.put("id", rs.getString("id"));
			map.put("name", rs.getString("name"));
			map.put("type", rs.getString("type"));
			map.put("uploader", rs.getString("uploader"));
			map.put("spectators", rs.getString("spectators"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		
		GetCon.colse(rs, pre, con);
		
	}
	
	return map;
	
}

public boolean editUser(Map map){
	
	boolean tt = false;
	Connection con = GetCon.getConnection();
	String sql = "update users set username = ?,sex = ?, age = ?, hiredate = ?, typrs = ? where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("username"));
		pre.setObject(2, map.get("sex"));
		pre.setObject(3, map.get("age"));
		pre.setObject(4, map.get("hiredate"));
		pre.setObject(5, map.get("typrs"));
		pre.setObject(6, map.get("id"));
		int i = pre.executeUpdate();
		if(i>0)
			tt = true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}

public boolean editMusic(Map map){
	
	boolean tt = false;
	Connection con = GetCon.getConnection();
	String sql = "update music set name = ?,type = ?, uploader = ?, amount = ?, sizes = ? where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("name"));
		pre.setObject(2, map.get("type"));
		pre.setObject(3, map.get("uploader"));
		pre.setObject(4, map.get("amount"));
		pre.setObject(5, map.get("sizes"));
		pre.setObject(6, map.get("id"));
		int i = pre.executeUpdate();
		if(i>0)
			tt = true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}

public boolean editGame(Map map){
	
	boolean tt = false;
	Connection con = GetCon.getConnection();
	String sql = "update game set name = ?,type = ?, uploader = ?, amount = ?, sizes = ? where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("name"));
		pre.setObject(2, map.get("type"));
		pre.setObject(3, map.get("uploader"));
		pre.setObject(4, map.get("amount"));
		pre.setObject(5, map.get("sizes"));
		pre.setObject(6, map.get("id"));
		int i = pre.executeUpdate();
		if(i>0)
			tt = true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}

public boolean editLive(Map map){
	
	boolean tt = false;
	Connection con = GetCon.getConnection();
	String sql = "update live set name = ?,type = ?, uploader = ?, spectators = ? where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setObject(1, map.get("name"));
		pre.setObject(2, map.get("type"));
		pre.setObject(3, map.get("uploader"));
		pre.setObject(4, map.get("spectators"));
		pre.setObject(5, map.get("id"));
		int i = pre.executeUpdate();
		if(i>0)
			tt = true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}
public boolean delUser(String id){
	
	boolean tt = false;
	
	Connection con = GetCon.getConnection();
	String sql = "delete users where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		int i = pre.executeUpdate();
		if(i>0){
			
			tt = true;
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}
public boolean delMusic(String id){
	
	boolean tt = false;
	
	Connection con = GetCon.getConnection();
	String sql = "delete music where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		int i = pre.executeUpdate();
		if(i>0){
			
			tt = true;
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}
public boolean delGame(String id){
	
	boolean tt = false;
	
	Connection con = GetCon.getConnection();
	String sql = "delete game where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		int i = pre.executeUpdate();
		if(i>0){
			
			tt = true;
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}
public boolean delLive(String id){
	
	boolean tt = false;
	
	Connection con = GetCon.getConnection();
	String sql = "delete live where id = ?";
	PreparedStatement pre = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, id);
		int i = pre.executeUpdate();
		if(i>0){
			
			tt = true;
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		GetCon.colse(null, pre, con);
	}
	
	return tt;
	
}

public Vector retrievalusers(String ss) {
	Vector vv = new Vector();
	Connection con = GetCon.getConnection();
	String sql = "select * from users where username like ?";
	PreparedStatement pre =null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, "%"+ss+"%");
		rs = pre.executeQuery();
		int i = 1;
		while (rs.next()) {
			
			Vector v = new Vector();
			v.add(i++);
			v.add(rs.getString("id"));
			v.add(rs.getString("username"));
			v.add(rs.getString("sex"));
			v.add(rs.getString("age"));
			v.add(rs.getString("hiredate"));
			v.add(rs.getString("typrs"));
			vv.add(v);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(rs, pre, con);
	}
	
	return vv;
	
}

public Vector retrievalmusic(String ss) {
	Vector vv = new Vector();
	Connection con = GetCon.getConnection();
	String sql = "select * from music where name like ?";
	PreparedStatement pre =null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, "%"+ss+"%");
		rs = pre.executeQuery();
		int i = 1;
		while (rs.next()) {
			
			Vector v = new Vector();
			v.add(i++);
			v.add(rs.getString("id"));
			v.add(rs.getString("name"));
			v.add(rs.getString("type"));
			v.add(rs.getString("uploader"));
			v.add(rs.getString("amount"));
			v.add(rs.getString("sizes"));
			vv.add(v);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(rs, pre, con);
	}
	
	return vv;
	
}
public Vector retrievalgame(String ss) {
	Vector vv = new Vector();
	Connection con = GetCon.getConnection();
	String sql = "select * from game where name like ?";
	PreparedStatement pre =null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, "%"+ss+"%");
		rs = pre.executeQuery();
		int i = 1;
		while (rs.next()) {
			
			Vector v = new Vector();
			v.add(i++);
			v.add(rs.getString("id"));
			v.add(rs.getString("name"));
			v.add(rs.getString("type"));
			v.add(rs.getString("uploader"));
			v.add(rs.getString("amount"));
			v.add(rs.getString("sizes"));
			vv.add(v);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(rs, pre, con);
	}
	
	return vv;
	
}
public Vector retrievallive(String ss) {
	Vector vv = new Vector();
	Connection con = GetCon.getConnection();
	String sql = "select * from live where name like ? ";
	PreparedStatement pre =null;
	ResultSet rs = null;
	try {
		pre = con.prepareStatement(sql);
		pre.setString(1, "%"+ss+"%");
		rs = pre.executeQuery();
		int i = 1;
		while (rs.next()) {
			
			Vector v = new Vector();
			v.add(i++);
			v.add(rs.getString("id"));
			v.add(rs.getString("name"));
			v.add(rs.getString("type"));
			v.add(rs.getString("uploader"));
			v.add(rs.getString("spectators"));
			vv.add(v);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		GetCon.colse(rs, pre, con);
	}
	
	return vv;
	
}

}

