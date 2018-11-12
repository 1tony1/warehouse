package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCon {
	
	public static Connection getConnection() {
		System.out.println("========连库开始========");
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.55.11:1521:orcl","scott", "tiger");
			System.out.println("========连库成功========");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void colse(ResultSet rs,PreparedStatement pre,Connection con) {
		try{
			
			if(rs!=null){
				rs.close();
			}
			if(pre!=null){
				pre.close();
			}
			if(con!=null){
				con.close();
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GetCon().getConnection();
	}
}
