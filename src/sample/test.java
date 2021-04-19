package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class test {

	private final StringProperty itemName ;
	private final StringProperty itemCode;
	private final StringProperty rate;
	private final StringProperty itemQuan;
	private final StringProperty tax;
	private final StringProperty amount;

	public test(String itemName,String itemCode,String rate,String itemQuan,String tax,String amount){

		this.itemName= new SimpleStringProperty(itemName);
		this.itemCode= new SimpleStringProperty(itemCode);
		this.rate= new SimpleStringProperty(rate);
		this.itemQuan= new SimpleStringProperty(itemQuan);
		this.tax= new SimpleStringProperty(tax);
		this.amount= new SimpleStringProperty(amount);
	}


	public String getItemName() {
		return itemName.get();
	}

	public StringProperty itemNameProperty() {
		return itemName;
	}

	public String getItemCode() {
		return itemCode.get();
	}

	public StringProperty itemCodeProperty() {
		return itemCode;
	}

	public String getRate() {
		return rate.get();
	}

	public StringProperty rateProperty() {
		return rate;
	}

	public String getItemQuan() {
		return itemQuan.get();
	}

	public StringProperty itemQuanProperty() {
		return itemQuan;
	}

	public String getTax() {
		return tax.get();
	}

	public StringProperty taxProperty() {
		return tax;
	}

	public String getAmount() {
		return amount.get();
	}

	public StringProperty amountProperty() {
		return amount;
	}
}
