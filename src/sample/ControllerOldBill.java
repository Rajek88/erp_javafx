package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ControllerOldBill implements Initializable {

	@FXML
	private Pane texure;

	@FXML
	private JFXTextField entiName;

	@FXML
	private JFXTextField entiCode;

	@FXML
	private JFXTextField entiQuan;

	@FXML
	private JFXButton saveBtn;

	@FXML
	private JFXButton updateBtn;

	@FXML
	private JFXButton delBtn;

	@FXML
	private Button print;

	@FXML
	private TableView<?> erpTable;

	@FXML
	private TableColumn<?, ?> itemName;

	@FXML
	private TableColumn<?, ?> itemCode;

	@FXML
	private TableColumn<?, ?> rate;

	@FXML
	private TableColumn<?, ?> itemQuan;

	@FXML
	private TableColumn<?, ?> tax;

	@FXML
	private TableColumn<?, ?> amount;

	@FXML
	private JFXTextField customerName;

	@FXML
	private Button addNewCustomer;

	@FXML
	private TextFlow total;

	@FXML
	private Button addNewEntry;

	@FXML
	private Button newBill;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

	@FXML
	private void handleClicks1(ActionEvent event){

		if (event.getSource()==newBill){
			openNewBill();
		}
		else
		if (event.getSource()==oldBill){}
		else
		if (event.getSource()==info){}
		else
		if (event.getSource()==customer){}
		else
		if (event.getSource()==addNewCustomer){}
		else
		if (event.getSource()==print){}
		else
		if (event.getSource()==addNewEntry){}

	}
    @FXML
	private void openNewBill() {
		try {
			System.out.println("Going back to home page");
			Stage stage = (Stage) newBill.getScene().getWindow();
			stage.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

}
