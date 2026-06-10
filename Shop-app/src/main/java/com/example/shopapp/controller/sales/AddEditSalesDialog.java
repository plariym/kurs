package com.example.shopapp.controller.sales;


import com.example.shopapp.model.Customer;
import com.example.shopapp.model.KindMoto;
import com.example.shopapp.model.Sales;

import com.example.shopapp.service.CustomerService;
import com.example.shopapp.service.KindMotoService;
import com.example.shopapp.service.SalesService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class AddEditSalesDialog implements Initializable {
    @FXML
    private ComboBox<KindMoto> kindMotoComboBox;
    @FXML
    private Label errorLabel;
    @FXML
    private ComboBox<Customer> customerComboBox;
    @FXML
    private TextField priceField;
    @FXML
    private Button okButton;
    @FXML
    private DatePicker datePicker;

    private Stage dialogStage;
    private Sales sales;

    List<Customer> allCustomer = new CustomerService().findAll();
    List<KindMoto> allKindMoto = new KindMotoService().findAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kindMotoComboBox.getItems().addAll(allKindMoto);
        customerComboBox.getItems().addAll(allCustomer);
    }

    private void add() {
        try {
            if (kindMotoComboBox.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить поле \"Вид мотоцикла\"");
            }
            if (customerComboBox.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить \"Покупатель\"");
            }

            Sales sales = new Sales();
            sales.setKindMoto(kindMotoComboBox.getValue());
            sales.setCustomer(customerComboBox.getValue());
            sales.setPrice(Integer.parseInt(priceField.getText()));
            sales.setDate(datePicker.getValue());

            SalesTableItem salesTableItem = new SalesTableItem(sales);
            new SalesService().save(sales);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            if (kindMotoComboBox.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить поле \"Вид мотоцикла\"");
            }
            if (customerComboBox.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить \"Покупатель\"");
            }
            sales.setKindMoto(kindMotoComboBox.getValue());
            sales.setCustomer(customerComboBox.getValue());
            sales.setPrice(Integer.parseInt(priceField.getText()));
            sales.setDate(datePicker.getValue());
            new SalesService().update(sales);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Sales sales) {
        this.sales = sales;
        this.dialogStage = dialogStage;

        kindMotoComboBox.getSelectionModel().select(sales.getKindMoto());
        customerComboBox.getSelectionModel().select(sales.getCustomer());
        priceField.setText(String.valueOf(sales.getPrice()));
        datePicker.setValue(sales.getDate());

        okButton.setOnAction((www) -> edit());
    }
}