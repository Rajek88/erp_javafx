package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

	private final StringProperty nCustomer;

	public Customer(String nCustomer){
		this.nCustomer=new SimpleStringProperty(nCustomer);

	}
	public String getnCustomer() {
		return nCustomer.get();
	}

	public StringProperty nCustomerProperty() {
		return nCustomer;
	}

}
