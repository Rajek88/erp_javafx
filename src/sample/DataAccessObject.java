package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
	private DBConnector database = new DBConnector();
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection connect;
	public DataAccessObject(){

	}
	public void saveData(String query) throws SQLException {
		try{
			connect=database.getConnection();//connect to database
			pstmt=connect.prepareStatement(query);
			pstmt.executeUpdate();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			database.close(connect,pstmt,null);
		}
	}

	public ObservableList<test> getTestData(String query) {
		ObservableList<test> list = FXCollections.observableArrayList();
		try {
			connect = database.getConnection();
			pstmt = connect.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new test(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public InputStream getreport(String report_name, String column_name){
		InputStream input=null;
		String query="SELECT "+column_name+" FROM reports WHERE report_name='"+report_name+"'";
		try {
			connect=database.getConnection();
			pstmt=connect.prepareStatement(query);
			rs=pstmt.executeQuery();
			while (rs.next()){
				input=rs.getBinaryStream(1);
			}

		}
		catch (Exception e)
		{
		  e.printStackTrace();
		}
		return input;
	    }
}