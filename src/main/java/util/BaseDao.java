package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	public final static String URL = "jdbc:mysql://127.0.0.1:3306/db_cookieshop?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&useSSL=false";
	public final static String USER="root";
	public final static String PWD="123456";
	public final static String DRIVER="com.mysql.cj.jdbc.Driver";
	
	public Connection open_db() throws SQLException {
		return DriverManager.getConnection(URL,USER,PWD);
	}
	
	public void close_db(Connection c,PreparedStatement pst,ResultSet rs) {
		try(Connection c1=c;PreparedStatement pst1=pst;ResultSet rs1=rs) {
			System.out.println(pst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
