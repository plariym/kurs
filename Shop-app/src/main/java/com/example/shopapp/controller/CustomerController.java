package com.example.shopapp.controller;


import com.example.shopapp.ShopMotoApp;
import com.example.shopapp.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;

import javafx.scene.control.cell.PropertyValueFactory;
import com.example.shopapp.repository.CustomerDao;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> passportColumn;

    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableView<Customer> customersTable;
    @FXML
    private TableColumn<Customer, String> fioColumn;
    @FXML
    void btnCustomers(ActionEvent event) {

    }
    @FXML
    void btnKindMoto(ActionEvent event) {

    }

    @FXML
    void btnAddCustomer(ActionEvent event) {

    }

    @FXML
    void btnDeleteCustomer(ActionEvent event) {

    }

    @FXML
    void btnEditCustomer(ActionEvent event) {

    }

    @FXML
    void btnOff(ActionEvent event) {
        ShopMotoApp.primaryStage.close();
    }

    @FXML
    void btnUpdateCustomers(ActionEvent event) {
        initController();
    }


    private final CustomerDao customerDao = new CustomerDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initController();
    }

    public void initController() {
        setCellValueFactories();
        List<Customer> customers = CustomerDao.findAll();
        customersTable.getItems().clear();
        for (Customer customer : customers) {
            customersTable.getItems().add(customer);
        }
        customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }
    private void setCellValueFactories() {
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));
    }
}
