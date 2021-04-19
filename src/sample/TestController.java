package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.Node;
import javafx.scene.SnapshotResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import sample.test;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TestController implements Initializable {

	@FXML
	private Pane texure;

	@FXML
	private JFXTextField entiName;

	@FXML
	private JFXTextField entiRate;

	@FXML
	private JFXTextField entiCode;

	@FXML
	private JFXTextField entiQuan;

	@FXML
	private JFXButton saveBtn;

	@FXML
	private JFXButton newBtn;

	@FXML
	private JFXButton updateBtn;

	@FXML
	private JFXButton delBtn;

	@FXML
	private Button print;

	@FXML
	private TableView<test> erpTable;

	@FXML
	private TableColumn<test, String> itemName;

	@FXML
	private TableColumn<test, String> itemCode;

	@FXML
	private TableColumn<test, String> rate;

	@FXML
	private TableColumn<test, String> itemQuan;

	@FXML
	private TableColumn<test, String> tax;

	@FXML
	private TableColumn<test, String> amount;

	@FXML
	private TextField customerNumber;

	@FXML
	private Button addNewCustomer;

	@FXML
	private TextFlow total;

	@FXML
	private Button addNewEntry;

	@FXML
	private Button newBill;

	@FXML
	private Button tools;

	@FXML
	private Button oldBill;

	@FXML
	private Button customer;

	@FXML
	private Button info;

	@FXML
	private Circle closeButton;

	@FXML
	private FontAwesomeIconView cross;
	private FXMLLoader loader1;
	private String query;
	private DataAccessObject dao=new DataAccessObject();
	private Connection connection;
	private Map<String,Object> map;
	private boolean EDIT=false,ADD=false;
//	private String queryForPhone="SELECT Customer_ID from customers where customers.custphone='"+customerNumber.getText()+"'";


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao=new DataAccessObject();
		saveBtn.setOnAction(event -> {
			try {
				insertData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		print.setOnAction(event -> {
			try {
				printReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
		});
		updateBtn.setOnAction(event -> {
			ADD=false;
			editData();
		});

		refreshTable();//veryyyyy importanttttttttttttttttttt
	}
	public void printReport() throws JRException {
		DBConnector database = new DBConnector();
		connection = database.getConnection();
		map=new HashMap<String, Object>();
		Report.createReport(connection,map,dao.getreport("account_report","report_jasper"));
		Report.showReport();


	}

	public void editData(){
		test selected=erpTable.getSelectionModel().getSelectedItem();
		entiName.setText(selected.itemNameProperty().get());
		entiCode.setText(selected.itemCodeProperty().get());
		entiQuan.setText(selected.itemQuanProperty().get());


	}
	public void newData(){
		test selected=erpTable.getSelectionModel().getSelectedItem();
		entiName.setText(selected.itemNameProperty().get());
		entiCode.setText(selected.itemCodeProperty().get());
		entiQuan.setText(selected.itemQuanProperty().get());


	}


	public void insertData() throws SQLException{
		int itemCode1 = Integer.parseInt(entiCode.getText());
		int itemQuan1= Integer.parseInt(entiQuan.getText());
		int itemRate1 = Integer.parseInt(entiRate.getText());
		double itemTax1=0.03;
		double itemAmount1=itemQuan1*itemRate1;
		double itemAmount2=itemAmount1+itemAmount1*itemTax1;
		query="INSERT INTO bills (Order_ID,itemName ,itemCode ,itemRate ,itemQuan ,itemtax ,itemAmount,Customer_ID)" +
				"VALUES (null,'"+entiName.getText()+"','"+itemCode1+"','"+itemRate1+"','"+itemQuan1+"','"+itemTax1+"','"+itemAmount2+"','"+customerNumber.getText()+"')";
		dao.saveData(query);
		itemName.setText("");
		itemCode.setText("");
		rate.setText("");
		itemQuan.setText("");
		tax.setText("");
		amount.setText("");
		refreshTable();   //importantttttttttttt

	}

	@FXML
	private void handleClicks(ActionEvent event){

		if (event.getSource()==newBill){}
		else
		if (event.getSource()==oldBill){
			openOldBill();
		}
		else
		if (event.getSource()==info){}
		else
		if (event.getSource()==customer){

		}
		else
		if (event.getSource()==addNewCustomer){
			openCustomer();
		}

		else
		if (event.getSource()==print){}
		else
		if (event.getSource()==addNewEntry){}

	}

	private void openOldBill() {
		try {
			System.out.println(System.getProperty("user.dir"));
			System.out.println("Going to oldbill page");

			// Java 7
			System.out.println(Paths.get("").toAbsolutePath().toString());
			loader1 = new FXMLLoader();
			loader1.setLocation(getClass().getResource("oldBill.fxml"));
			loader1.load();
			Scene scene=new Scene(loader1.getRoot());
			Stage stage=new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.setTitle("Texture Softwares");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	public void openCustomer(){

		try {
			loader1 = new FXMLLoader();
			loader1.setLocation(getClass().getResource("customer.fxml"));
			loader1.load();
			Scene scene=new Scene(loader1.getRoot());
			Stage stage=new Stage();
			stage.setResizable(false);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
	private void initTable(){
		//////////////////////Start here

		itemName.setCellValueFactory(cell->cell.getValue().itemNameProperty());
		itemCode.setCellValueFactory(cell->cell.getValue().itemCodeProperty());
		rate.setCellValueFactory(cell->cell.getValue().rateProperty());
		itemQuan.setCellValueFactory(cell->cell.getValue().itemQuanProperty());
		tax.setCellValueFactory(cell->cell.getValue().taxProperty());
		amount.setCellValueFactory(cell->cell.getValue().amountProperty());// imported proper getters

	}
	private void refreshTable(){
		initTable();
		query="SELECT itemName,itemCode,itemRate,itemQuan,itemTax,itemAmount from bills";
		erpTable.setItems(dao.getTestData(query));
	}


}
