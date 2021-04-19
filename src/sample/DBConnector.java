package sample;

import java.sql.*;

public class DBConnector {
	private final String DBurl="jdbc:mysql://localhost/javafx_jasper";
	private final String username="root";
	private final String password="";
	private Connection connection;

	public DBConnector(){

	}

	public Connection getConnection(){
		try {
			connection= DriverManager.getConnection(DBurl,username,password);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	public void close(Connection connect, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(connect!=null)
			connect.close();
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
	}
	public void close(Connection connect,PreparedStatement pstmt) throws SQLException {
		close(connect,pstmt,null);
	}
	public void close(PreparedStatement pstmt) throws SQLException {
		close(null,pstmt,null);
	}

}
