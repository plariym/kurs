package com.example.shopapp.controller.client;
import com.example.shopapp.service.CustomerService;
import com.example.shopapp.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class AddEditCustomerDialog implements Initializable {
    @FXML
    private TextField addressField;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField passportField;
    @FXML
    private TextField fioField;
    @FXML
    private Button okButton;
    @FXML
    private TextField phoneField;
    private Stage dialogStage;
    private Customer customer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    private void add() {
        try {
            Customer customer = new Customer();
            customer.setFio(fioField.getText());
            customer.setPhone(phoneField.getText());
            customer.setAddress(addressField.getText());
            customer.setPassport(passportField.getText());
            CustomerTableItem CustomerTableItem = new CustomerTableItem(customer);
            new CustomerService().save(customer);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    void edit() {
        try {
            customer.setFio(fioField.getText());
            customer.setPhone(phoneField.getText());
            customer.setAddress(addressField.getText());
            customer.setPassport(passportField.getText());
            new CustomerService().update(customer);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }
    public void setEditDialogStage(Stage dialogStage, Customer customer) {
        this.customer = customer;
        this.dialogStage = dialogStage;
        fioField.setText(customer.getFio());
        passportField.setText(customer.getPassport());
        addressField.setText(customer.getAddress());
        phoneField.setText(customer.getPhone());
        okButton.setOnAction((www) -> edit());
    }
}
