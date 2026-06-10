package com.example.shopapp.controller.sales;

import com.example.shopapp.ShopMotoApp;
import com.example.shopapp.model.Sales;
import com.example.shopapp.service.SalesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class SalesController {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnKindMoto;

    @FXML
    private Button btnOff;

    @FXML
    private Button btnSales;

    @FXML
    private TableColumn<?, ?> customerColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> kindMotoColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableView<SalesTableItem> salesTable;

    private List<Sales> sales;
    private ObservableList<SalesTableItem> salesObservable;

    public void initialize() {
        kindMotoColumn.setCellValueFactory(new PropertyValueFactory<>("kindMoto"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        salesObservable = FXCollections.observableArrayList();
        salesTable.setItems(salesObservable);

        updateList();
    }

    @FXML
    void btnAddSalesAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-sales-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(ShopMotoApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("добавить Продажу");
            AddEditSalesDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }



    @FXML
    void btnDeleteSalesAction(ActionEvent event) {
        SalesTableItem currentItem = salesTable.getSelectionModel().getSelectedItem();
        int currentItemId = salesTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getKindMoto() + "\"?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                new SalesService().delete(currentItem.getSales());
                salesTable.getItems().remove(currentItemId);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void btnEditSalesAction(ActionEvent event) {
        SalesTableItem currentItem = salesTable.getSelectionModel().getSelectedItem();
        int currentItemId = salesTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(ShopMotoApp.class.getResource("add-edit-sales-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(ShopMotoApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать продажи");
                AddEditSalesDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getSales());
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
    void btnUpdateSalesAction(ActionEvent event) {
        updateList();
    }

    public void updateList() {
        try {
            sales = new SalesService().findAll();
            salesObservable.clear();

            if (sales != null) {
                for (Sales Sales : sales) {
                    salesObservable.add(new SalesTableItem(Sales));
                }
            }
            salesTable.refresh();

        } catch (Exception e) {
            System.err.println("Ошибка в updateList():");
            e.printStackTrace();
        }
    }


    @FXML
    void btnCustomers(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.customers);
    }

    @FXML
    void btnSalesAction(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.sales);
    }

    @FXML
    void btnKindMotoAction(ActionEvent event) {
        ShopMotoApp.primaryStage.setScene(ShopMotoApp.kindMoto);
    }

}