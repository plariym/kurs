package com.example.shopapp.controller.client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.shopapp.ShopMotoApp;
import com.example.shopapp.model.Customer;
import com.example.shopapp.repository.CustomerDao;
import com.example.shopapp.service.CustomerService;
import java.util.Optional;
public class CustomerController {
    private List<Customer> customers;
    private ObservableList<CustomerTableItem> creditsObservable;

    @FXML
    private TableColumn<?, ?> addressColumn;
    @FXML
    private TableColumn<?, ?> passportColumn;
    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableView<CustomerTableItem> customersTable;
    @FXML
    private TableColumn<Customer, String> fioColumn;
    private final CustomerDao customerDao = new CustomerDao();
    public void initialize() {
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));
        creditsObservable = FXCollections.observableArrayList();
        customersTable.setItems(creditsObservable);
        updateList();
    }

    @FXML
    void btnSalersAction(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.sales);
    }
    @FXML
    void btnKindMoto(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.kindMoto);
    }
    @FXML
    void btnCustomers(ActionEvent event) {
        updateList();
    }
    @FXML
    void btnAddCustomer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-customer-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(ShopMotoApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить клиента");
            AddEditCustomerDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }
    private void updateList() {
        try {
            customers = new CustomerService().findAll();
            creditsObservable.clear();
            if (customers != null) {
                for (Customer customer : customers) {
                    creditsObservable.add(new CustomerTableItem(customer));
                }
            }
            customersTable.refresh();
        } catch (Exception e) {
            System.err.println("Ошибка в updateList():");
            e.printStackTrace();
        }
    }
    @FXML
    void btnDeleteCustomer(ActionEvent event) {
        CustomerTableItem currentItem = customersTable.getSelectionModel().getSelectedItem();
        int currentItemId = customersTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getFio() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new CustomerService().delete(currentItem.getCustomer());
                customersTable.getItems().remove(currentItemId);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }
    @FXML
    void btnEditCustomer(ActionEvent event) {
        CustomerTableItem currentItem = customersTable.getSelectionModel().getSelectedItem();
        int currentItemId = customersTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-customer-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(ShopMotoApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать клиента");
                AddEditCustomerDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage,currentItem.getCustomer());
                dialogStage.showAndWait();
                updateList();
            } catch (IOException e) {
                System.out.println("Ошибка открытия окна: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }
    @FXML
    void btnOff(ActionEvent event) {
        ShopMotoApp.primaryStage.close();
    }
    @FXML
    void btnUpdateCustomers(ActionEvent event) {
        updateList();
    }
}