package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class  ControllerCustomer implements Initializable {

	@FXML
	private JFXTextField newCustName;

	@FXML
	private JFXTextField phone;

	@FXML
	private JFXTextField addr;

	@FXML
	private JFXButton saveCust;

	private String query;
	private DataAccessObject dao=new DataAccessObject();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao=new DataAccessObject();
		saveCust.setOnAction(event -> {
			try {
				insertData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			openNewBill();
		});

	}
	public void insertData() throws SQLException{
		query="INSERT INTO customers (Customer_ID,custname, custphone, custaddress)" +
				"VALUES (null,'"+newCustName.getText()+"','"+phone.getText()+"','"+addr.getText()+"')";
		dao.saveData(query);
	}
	@FXML
	private void openNewBill() {
		try {
			System.out.println("Going back to home page");
			Stage stage = (Stage) saveCust.getScene().getWindow();
			stage.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
}
